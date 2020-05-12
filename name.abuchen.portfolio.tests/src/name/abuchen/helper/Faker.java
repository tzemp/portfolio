package name.abuchen.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import name.abuchen.portfolio.model.Security;

@SuppressWarnings("nls")
public class Faker
{
    public String getRandomString()
    {
        int rand = ThreadLocalRandom.current().nextInt(1, 5);
        switch (rand)
        {
            case 1:
                return this.getString();
            case 2:
                return this.getInt();
            case 3:
                return this.getDateTime();
            case 4:
                return this.getFloat();
            default:
                return this.getString();
        }
    }

    public String getString()
    {
        int leftLimit = (int) '0'; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return generatedString;
    }

    public String getInt()
    {
        int price = ThreadLocalRandom.current().nextInt(1, 200) * 100;
        return String.valueOf(price);
    }

    public String getFloat()
    {
        int upper = ThreadLocalRandom.current().nextInt(1, 200);
        int lower = ThreadLocalRandom.current().nextInt(1, 200);
        float result = (float) upper / lower;
        return String.valueOf(result);
    }

    public String getDateTime()
    {
        int hundredYears = 100 * 365;
        LocalDate date = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-hundredYears, hundredYears));
        return date.toString();
    }

    public File getFile() throws IOException
    {
        String fileName = "/tmp/buchen-tests/" + this.getString() + ".txt";
        
        FileOutputStream outputStream = new FileOutputStream(fileName);
                    
        StringBuilder append = new StringBuilder();

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(200, 10000); i++)
        {
            append.append(this.getString());
        }
        byte[] strToBytes = append.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();

        File file = new File(fileName);

        return file;
    }

    public List<File> getFiles(int numberOfFiles) throws IOException
    {
        List<File> files = new ArrayList<File>();
        for (int i = 0; i < numberOfFiles; i++)
        {
            files.add(this.getFile());
        }
        return files;
    }
}
