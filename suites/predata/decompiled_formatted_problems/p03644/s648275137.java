import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Main
{
    public static void main(final String[] array) throws IOException {
        final int int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = 0;
        int x = int1;
        for (int i = 1; i <= int1; ++i) {
            if (i % 2 == 0) {
                int n2;
                int n3;
                for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
                if (n3 > n) {
                    n = n3;
                    x = i;
                }
            }
        }
        System.out.println(x);
    }
}