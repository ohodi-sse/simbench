import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String line = bufferedReader.readLine();
        final String line2 = bufferedReader.readLine();
        final char[] array2 = new char[3];
        final char[] array3 = new char[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            array2[i] = line.charAt(i);
            array3[i] = line2.charAt(i);
            if (array2[i] == array3[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}