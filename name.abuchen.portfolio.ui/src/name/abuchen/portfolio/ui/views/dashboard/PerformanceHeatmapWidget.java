package name.abuchen.portfolio.ui.views.dashboard;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import name.abuchen.portfolio.model.Dashboard.Widget;
import name.abuchen.portfolio.money.Values;
import name.abuchen.portfolio.snapshot.PerformanceIndex;
import name.abuchen.portfolio.snapshot.ReportingPeriod;
import name.abuchen.portfolio.ui.Messages;
import name.abuchen.portfolio.ui.util.ContextMenu;
import name.abuchen.portfolio.ui.views.dataseries.DataSeries;
import name.abuchen.portfolio.util.Interval;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class PerformanceHeatmapWidget extends WidgetDelegate
{
    private Composite table;
    private Label title;
    private DashboardResources resources;

    public PerformanceHeatmapWidget(Widget widget, DashboardData data)
    {
        super(widget, data);

        addConfig(new ReportingPeriodConfig(this));
        addConfig(new DataSeriesConfig(this, true));
    }

    @Override
    Composite createControl(Composite parent, DashboardResources resources)
    {
        this.resources = resources;

        Composite container = new Composite(parent, SWT.NONE);
        GridLayoutFactory.fillDefaults().numColumns(1).margins(5, 5).applyTo(container);
        container.setBackground(parent.getBackground());

        title = new Label(container, SWT.NONE);
        // title.setText(getWidget().getLabel());
        GridDataFactory.fillDefaults().grab(true, false).applyTo(title);

        table = new Composite(container, SWT.NONE);
        // 13 columns, one for the legend and 12 for the months
        GridLayoutFactory.fillDefaults().numColumns(13).spacing(1, 1).applyTo(table);
        table.setBackground(container.getBackground());
        fillTable();

        return container;
    }

    private Color getScaledColorForPerformance(double performance)
    {
        double max = 0.05;
        double min = max * (-1d);
        performance = Math.min(max, performance);
        performance = Math.max(min, performance);
        if (performance > 0d)
        {
            return resources.getResourceManager().createColor(
                            new RGB(new Double(255 * (1 - performance / max)).intValue(), 255, new Double(
                                            255 * (1 - performance / max)).intValue()));
        }
        else
        {
            return resources.getResourceManager().createColor(
                            new RGB(255, new Double(255 * (1 - performance / min)).intValue(), new Double(
                                            255 * (1 - performance / min)).intValue()));
        }
    }

    private void fillTable()
    {
        // fill the table lines according to the supplied period
        // calculate the performance with a temporary reporting period
        // calculate the color interpolated between red and green with white as
        // the median
        Interval interval = get(ReportingPeriodConfig.class).getReportingPeriod().toInterval();
        ReportingPeriod currPeriod;

        // Top Left is empty
        Label topLeft = new Label(table, SWT.NONE);
        topLeft.setText(""); //$NON-NLS-1$

        // then the legend of the months
        // no harm in hardcoding the year as each year has the same months
        for (LocalDate legendMonth = LocalDate.of(2016, 1, 1); legendMonth.getYear() == 2016; legendMonth = legendMonth
                        .plusMonths(1))
        {
            Label currLabel = new Label(table, SWT.NONE);
            currLabel.setText(legendMonth.getMonth().getDisplayName(TextStyle.NARROW, Locale.GERMAN));
            currLabel.setAlignment(SWT.CENTER);
        }

        // now loop the years
        DataSeries dataSeries = get(DataSeriesConfig.class).getDataSeries();

        for (LocalDate yearDate : interval.iterYears())
        {
            Label currLabel = new Label(table, SWT.NONE);
            currLabel.setText(String.valueOf(yearDate.getYear()));
            GridDataFactory.fillDefaults().grab(true, false).applyTo(currLabel);

            for (LocalDate currMonth = LocalDate.of(yearDate.getYear(), 1, 1); currMonth.getYear() == yearDate
                            .getYear(); currMonth = currMonth.plusMonths(1))
            {
                currLabel = new Label(table, SWT.RIGHT);
                if (interval.contains(currMonth))
                {
                    currPeriod = new ReportingPeriod.FromXtoY(currMonth.minusDays(1),
                                    currMonth.withDayOfMonth(currMonth.lengthOfMonth()));
                    if (currPeriod.getEndDate().isAfter(interval.getEnd()) || currMonth.isBefore(interval.getStart()))
                    {
                        currLabel.setToolTipText(Messages.PerformanceHeatmapToolTip);
                    }
                    currLabel.setFont(resources.getSmallFont());
                    PerformanceIndex performance = getDashboardData().calculate(dataSeries, currPeriod);
                    currLabel.setText(Values.PercentShort.format(performance.getFinalAccumulatedPercentage()));
                    currLabel.setBackground(getScaledColorForPerformance(performance.getFinalAccumulatedPercentage()));
                }
                GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(currLabel);
            }
        }
        table.layout(true);
    }

    @Override
    void update()
    {
        // title.setText(getWidget().getLabel());
        for (Control child : table.getChildren())
            child.dispose();
        fillTable();
        table.getParent().layout(true);
        table.getParent().getParent().layout(true);
    }

    @Override
    void attachContextMenu(IMenuListener listener)
    {
        new ContextMenu(title, listener).hook();
    }

}
