import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final long long1 = Long.parseLong(stringTokenizer.nextToken());
        final int n = (int)(Double.parseDouble(stringTokenizer.nextToken()) * 100.0001);
        printWriter.println((long1 * n - long1 % 100L * (n % 100) % 100L) / 100L);
        printWriter.close();
    }
}