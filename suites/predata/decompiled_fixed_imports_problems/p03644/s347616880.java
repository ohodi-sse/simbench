import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final int int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int max = 0;
        for (int i = 2; i <= int1; i *= 2) {
            max = Math.max(max, i);
        }
        System.out.println((int1 == 1) ? 1 : max);
    }
}