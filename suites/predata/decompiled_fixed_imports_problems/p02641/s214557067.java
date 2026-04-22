import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main
{
    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    
    private static void solve() {
        final int ni = ni();
        final int ni2 = ni();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < ni2; ++i) {
            list.add(ni());
        }
        final HashMap hashMap = new HashMap();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            hashMap.put((int)iterator.next(), true);
        }
        int x = -1;
        for (int j = 0; j <= 100; ++j) {
            final int k = ni - j;
            final int l = ni + j;
            if (!hashMap.containsKey(k)) {
                x = k;
                break;
            }
            if (!hashMap.containsKey(l)) {
                x = l;
                break;
            }
        }
        System.out.println(x);
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
        solve();
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