import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        final String substring = line.substring(0, 1);
        final String substring2 = line.substring(1, 2);
        final String substring3 = line.substring(2, 3);
        int x = 0;
        if (substring.equals("R")) {
            x = 1;
            if (substring2.equals("R")) {
                x = 2;
                if (substring3.equals("R")) {
                    x = 3;
                }
            }
        }
        else if (substring2.equals("R")) {
            x = 1;
            if (substring3.equals("R")) {
                x = 2;
            }
        }
        else if (substring3.equals("R")) {
            x = 1;
        }
        System.out.println(x);
    }
}