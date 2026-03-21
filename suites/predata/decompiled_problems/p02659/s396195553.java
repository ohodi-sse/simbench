import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;





public class Main
{
    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    
    private static void solve() {
        final long nl = nl();
        final char[] charArray = next().toCharArray();
        long n = 0L;
        int n2 = 2;
        for (final char ch : charArray) {
            if (ch != '.') {
                n += Character.getNumericValue(ch) * (long)Math.pow(10.0, n2);
                --n2;
            }
        }
        System.out.println(nl * n / 100L);
    }
    
    public static void main(final String[] array) {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        final String getenv = System.getenv("DD_PATH");
        if (getenv != null) {
            try {
                Main.br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getenv))));
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
        }
        int i = 1;
        while (i != 0) {
            solve();
            try {
                Main.br.mark(1);
                if (Main.br.read() > 0) {
                    Main.br.reset();
                    System.out.println("---");
                }
                else {
                    i = 0;
                }
                continue;
            }
            catch (final Exception cause2) {
                throw new RuntimeException(cause2);
            }
            break;
        }
    }
    
    public static String next() {
        while (true) {
            if (Main.tokenizer != null) {
                if (Main.tokenizer.hasMoreTokens()) {
                    break;
                }
            }
            try {
                Main.tokenizer = new StringTokenizer(Main.br.readLine());
                continue;
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return Main.tokenizer.nextToken();
    }
    
    private static int ni() {
        return Integer.parseInt(next());
    }
    
    private static long nl() {
        return Long.parseLong(next());
    }
    
    private static double nd() {
        return Double.parseDouble(next());
    }
    
    private static int[] na(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = ni();
        }
        return array;
    }
    
    private static char[] ns() {
        return next().toCharArray();
    }
    
    private static long[] nal(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = nl();
        }
        return array;
    }
    
    static {
        Main.tokenizer = null;
    }
}