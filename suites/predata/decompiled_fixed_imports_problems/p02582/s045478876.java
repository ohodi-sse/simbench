import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws Exception {
        try {
            final String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
            int x = 0;
            int n = 0;
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == 'R') {
                    x = ++n;
                }
                else {
                    n = 0;
                }
            }
            System.out.println(x);
        }
        catch (final Exception x2) {
            System.out.println(x2);
        }
    }
}