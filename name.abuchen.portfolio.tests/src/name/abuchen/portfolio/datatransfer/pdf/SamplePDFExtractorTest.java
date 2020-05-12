package name.abuchen.portfolio.datatransfer.pdf;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.Test;

import name.abuchen.portfolio.datatransfer.SecurityCache;
import name.abuchen.portfolio.model.Client;

@SuppressWarnings("nls")
public class SamplePDFExtractorTest
{
    public class SamplePDFExtractor extends AbstractPDFExtractor
    {

        public SamplePDFExtractor(Client client)
        {
            super(client);
            this.addBankIdentifier("sampleIdentifier");
            this.addBankIdentifier("sampleIdentifier2");
        }

        @Override
        public String getLabel()
        {
            return "sample";
        }

        @Override
        public List<Item> extract(SecurityCache securityCache, InputFile file, List<Exception> errors)
        {
            return null;
        }
    }

    @Test
    public void testConstruct()
    {
        Client client = new Client();

        SamplePDFExtractor extractor = new SamplePDFExtractor(client);
        
        assertTrue(extractor.getBankIdentifier().size() == 2);
    }

}
