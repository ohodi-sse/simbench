import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.HashSet;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    static final long MOD = 998244353L;
    static String letters;
    static final int INF = 1000000007;
    
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int ni = fastScanner.ni();
        final int ni2 = fastScanner.ni();
        final HashSet set = new HashSet();
        for (int i = 0; i < ni2; ++i) {
            set.add(fastScanner.ni());
        }
        for (int j = 0; j <= 100; ++j) {
            if (!set.contains(ni - j)) {
                printWriter.println(ni - j);
                printWriter.close();
                return;
            }
            if (!set.contains(ni + j)) {
                printWriter.println(ni + j);
                printWriter.close();
                return;
            }
        }
        printWriter.close();
    }
    
    public static long dist(final long[] array, final long[] array2) {
        return Math.abs(array2[0] - array[0]) + Math.abs(array2[1] - array[1]);
    }
    
    public static long gcd(final long n, final long n2) {
        if (n < n2) {
            return gcd(n2, n);
        }
        if (n2 == 0L) {
            return n;
        }
        return gcd(n2, n % n2);
    }
    
    public static long power(long n, long n2, final long n3) {
        if (n2 < 0L) {
            return 0L;
        }
        long n4 = 1L;
        for (n %= n3; n2 > 0L; n2 /= 2L, n = n * n % n3) {
            if (n2 % 2L == 1L) {
                n4 = n4 * n % n3;
            }
        }
        return n4;
    }
    
    public static int[] shuffle(final int[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final int n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
        return array;
    }
    
    public static long[] shuffle(final long[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final long n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
        return array;
    }
    
    public static int[][] sort(final int[][] a) {
        final Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            final int nextInt = random.nextInt(a.length);
            final int[] array = a[i];
            a[i] = a[nextInt];
            a[nextInt] = array;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(final int[] array, final int[] array2) {
                return array[0] - array2[0];
            }
        });
        return a;
    }
    
    public static long[][] sort(final long[][] a) {
        final Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            final int nextInt = random.nextInt(a.length);
            final long[] array = a[i];
            a[i] = a[nextInt];
            a[nextInt] = array;
        }
        Arrays.sort(a, new Comparator<long[]>() {
            @Override
            public int compare(final long[] array, final long[] array2) {
                if (array[0] < array2[0]) {
                    return -1;
                }
                return 1;
            }
        });
        return a;
    }
    
    static {
        Main.letters = "abcdefghijklmnopqrstuvwxyz";
    }
    
    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        int ni() {
            return Integer.parseInt(this.next());
        }
        
        long nl() {
            return Long.parseLong(this.next());
        }
        
        double nd() {
            return Double.parseDouble(this.next());
        }
        
        String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}