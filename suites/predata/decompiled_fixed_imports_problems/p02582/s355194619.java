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
        final String line = bufferedReader.readLine();
        int max = 0;
        int b = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        printWriter.println(max);
        printWriter.flush();
        printWriter.close();
    }
}