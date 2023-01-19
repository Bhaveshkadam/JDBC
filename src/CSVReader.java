import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void read(String csvFile) {
        String delimiter = ",";
        String mystring;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((mystring = br.readLine()) != null)  //Reads a line of text
            {
                String[] qa = mystring.split(delimiter); //utilized to split the string
                System.out.println("Question: " + qa[0] + ", Answer: " + qa[1] );
            }
        }
        catch (IOException e)//catches exception in the try block
        {
            e.printStackTrace();//Prints this throwable and its backtrace
        }
    }
}