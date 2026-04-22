import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws Exception {
        final StringTokenizer stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        final PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(Math.round(Double.parseDouble(stringTokenizer.nextToken()) * 100.0) * Long.parseLong(stringTokenizer.nextToken()) / 100L);
        printWriter.close();
    }
}