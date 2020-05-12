package name.abuchen.portfolio.datatransfer.pdf;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.Test;
import org.mockito.Mockito;

import name.abuchen.helper.Faker;
import name.abuchen.portfolio.model.Client;

@SuppressWarnings("nls")
public class FuzzTestingTest
{
    @Test
    public void testRandomFile() throws IOException
    {
        IProgressMonitor monitor = Mockito.mock(IProgressMonitor.class);
        Map<File, List<Exception>> errors = new HashMap<File, List<Exception>>();
        
        Faker faker = new Faker();
        Client client = new Client();
        List<File> files = faker.getFiles(100);

        PDFImportAssistant assistant = new PDFImportAssistant(client, files);
        assistant.run(monitor, errors);
        System.out.println("Runned");
    }
}
