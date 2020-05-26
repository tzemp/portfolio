package name.abuchen.portfolio.snapshot.security;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import name.abuchen.portfolio.PortfolioBuilder;
import name.abuchen.portfolio.SecurityBuilder;
import name.abuchen.portfolio.TestCurrencyConverter;
import name.abuchen.portfolio.model.Client;
import name.abuchen.portfolio.model.Portfolio;
import name.abuchen.portfolio.model.PortfolioTransaction;
import name.abuchen.portfolio.model.Security;
import name.abuchen.portfolio.model.Transaction;
import name.abuchen.portfolio.model.Transaction.Unit;
import name.abuchen.portfolio.money.CurrencyUnit;
import name.abuchen.portfolio.money.Money;
import name.abuchen.portfolio.money.Values;

import org.junit.Test;

@SuppressWarnings("nls")
public class DividendTransactionTest
{
    @Test
    public void testDividendPerShare()
    {
        List<Transaction> tx = new ArrayList<>();

        // we buy 1000 shares
        Security security = new Security("Apple ORD", CurrencyUnit.USD);
        tx.add(new PortfolioTransaction(LocalDateTime.of(2019, Month.DECEMBER, 31, 0, 0), //
                        CurrencyUnit.USD, 1000, //
                        security, 10, PortfolioTransaction.Type.BUY, //
                        10, 0));

        DividendTransaction t = new DividendTransaction();
        t.setDateTime(LocalDateTime.parse("2020-05-20T00:00"));
        t.setSecurity(security);
        t.setMonetaryAmount(Money.of(CurrencyUnit.USD, 100));
        t.setShares(10);
        t.addUnit(new Unit(Unit.Type.TAX, Money.of(CurrencyUnit.USD, 5)));
        tx.add(t);

        long result = t.getDividendPerShare();

        assertEquals(result, 1l);
    }
}
