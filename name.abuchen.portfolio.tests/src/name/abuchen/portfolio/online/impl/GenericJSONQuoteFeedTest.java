package name.abuchen.portfolio.online.impl;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import name.abuchen.helper.Faker;
import name.abuchen.portfolio.model.Security;
import name.abuchen.portfolio.model.SecurityProperty;
import name.abuchen.portfolio.money.Values.MoneyValues;
import name.abuchen.portfolio.online.QuoteFeedData;
import name.abuchen.portfolio.util.WebAccess;

@SuppressWarnings("nls")
public class GenericJSONQuoteFeedTest
{
    String feedUrl;
    Security security;
    Faker faker;

    @Before
    public void setup()
    {
        feedUrl = "https://google.com/appl";
        security = new Security();
        security.setTickerSymbol("AAPL");
        security.setFeedURL(feedUrl);
        security.setPropertyValue(SecurityProperty.Type.FEED, GenericJSONQuoteFeed.DATE_PROPERTY_NAME,
                        "$.data[*].date");
        security.setPropertyValue(SecurityProperty.Type.FEED, GenericJSONQuoteFeed.CLOSE_PROPERTY_NAME,
                        "$.data[*].close");

        faker = new Faker();
    }

    @Test
    public void testPureRandom() throws IOException, URISyntaxException
    {
        int loops = 100;

        for (int i = 0; i < loops; i++)
        {
            String randomJson = this.getPureRandomJson();

            GenericJSONQuoteFeed feed = Mockito.spy(new GenericJSONQuoteFeed());
            Mockito.doReturn(randomJson).when(feed).getJson(feedUrl);

            try
            {
                QuoteFeedData data = feed.getHistoricalQuotes(security, true);
            }
            catch (Exception e)
            {
                System.out.println("Crashed due to :" + e.toString());
            }
            System.out.println("Parsed sucessfully");
        }
    }

    @Test
    public void testReasonableRandom() throws IOException, URISyntaxException
    {
        int loops = 100;
        int crashes = 0;

        for (int i = 0; i < loops; i++)
        {
            String randomJson = this.getReasonableRandomJson();

            GenericJSONQuoteFeed feed = Mockito.spy(new GenericJSONQuoteFeed());
            Mockito.doReturn(randomJson).when(feed).getJson(feedUrl);

            try
            {
                QuoteFeedData data = feed.getHistoricalQuotes(security, false);
                System.out.println("Parsed sucessfully");
            }
            catch (Exception e)
            {
                System.out.println("Crashed due to :" + e.toString());
                crashes++;
            }
        }
        System.out.println("Crashed " + crashes + " times");
    }

    @SuppressWarnings("unchecked")
    private String getReasonableRandomJson()
    {
        JSONObject outer = new JSONObject();

        outer.put("info", "Json Feed for APPLE ORD");

        JSONArray arr = new JSONArray();
        int nodes = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        for (int i = 0; i < nodes; i++)
        {
            JSONObject tmp = new JSONObject();
            tmp.put("date", faker.getRandomString());
            tmp.put("close", faker.getRandomString());
            arr.add(tmp);
        }

        outer.put("data", arr);

        return outer.toJSONString();
    }

    @SuppressWarnings("unchecked")
    private String getPureRandomJson()
    {
        JSONArray arr = new JSONArray();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(0, 20 + 1); i++)
        {
            JSONObject tmp = new JSONObject();
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(0, 20 + 1); j++)
            {
                if (ThreadLocalRandom.current().nextInt(0, 3 + 1) == 3)
                {
                    JSONArray arr2 = new JSONArray();
                    for (int k = 0; k < ThreadLocalRandom.current().nextInt(0, 20 + 1); k++)
                    {
                        JSONObject tmp2 = new JSONObject();
                        for (int l = 0; l < ThreadLocalRandom.current().nextInt(0, 20 + 1); l++)
                        {
                            tmp2.put(faker.getString(), faker.getRandomString());
                        }
                        arr2.add(tmp2);
                    }
                    tmp.put(faker.getString(), arr2);
                }
                else
                {
                    tmp.put(faker.getString(), faker.getRandomString());
                }
            }
            arr.add(tmp);
        }
        return arr.toJSONString();
    }
}
