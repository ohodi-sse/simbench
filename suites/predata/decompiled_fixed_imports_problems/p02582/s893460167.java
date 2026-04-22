import java.io.IOException;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String[] split = new StringTokenizer(bufferedReader.readLine()).nextToken().split("");
        int x = 0;
        boolean b = false;
        final String[] array2 = split;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if ("R".equals(array2[i])) {
                ++x;
                b = true;
            }
            else if (b) {
                break;
            }
        }
        printWriter.println(x);
        bufferedReader.close();
        printWriter.close();
    }
}