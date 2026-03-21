import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final String nextToken = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()).nextToken();
        int x = 0;
        char c = nextToken.charAt(0);
        int n = 1;
        for (int i = 1; i < 3; ++i) {
            if (nextToken.charAt(i) == c) {
                ++n;
            }
            else {
                if (c == 'R') {
                    x = Math.max(x, n);
                }
                n = 1;
                c = nextToken.charAt(i);
            }
        }
        if (c == 'R') {
            x = Math.max(x, n);
        }
        System.out.println(x);
    }
}