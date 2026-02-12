import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Random;
import java.io.OutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static FastReader sc;
    private static PrintWriter out;
    private static long mod;
    
    private static void process() throws IOException {
        Main.out.println((Object)new BigDecimal(Main.sc.next()).multiply(new BigDecimal(Main.sc.next())).setScale(0, RoundingMode.FLOOR).toString());
    }
    
    private static void main$3231c38a() throws IOException {
        Main.out = new PrintWriter(System.out);
        Main.sc = new FastReader();
        final long currentTimeMillis = System.currentTimeMillis();
        int n = 1;
        while (n-- > 0) {
            Main.out.println((Object)new BigDecimal(Main.sc.next()).multiply(new BigDecimal(Main.sc.next())).setScale(0, RoundingMode.FLOOR).toString());
        }
        Main.out.flush();
        System.err.println(System.currentTimeMillis() - currentTimeMillis + "ms");
    }
    
    private static void pn(final Object x) {
        Main.out.println(x);
    }
    
    private static void p(final Object obj) {
        Main.out.print(obj);
    }
    
    private static int ni() throws IOException {
        return Integer.parseInt(Main.sc.next());
    }
    
    private static long nl() throws IOException {
        return Long.parseLong(Main.sc.next());
    }
    
    private static double nd() throws IOException {
        return Double.parseDouble(Main.sc.next());
    }
    
    private static String nln() throws IOException {
        return Main.sc.nextLine();
    }
    
    private static long gcd(long n, long n2) throws IOException {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static int gcd(int n, int i) throws IOException {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static int bit(final long n) throws IOException {
        if (n == 0L) {
            return 0;
        }
        return 1 + bit(n & n - 1L);
    }
    
    private static <T> void r_sort(final T[] a, int i) {
        final Random random = new Random();
        --i;
        while (i > 0) {
            final int nextInt = random.nextInt(i + 1);
            final T t = a[i];
            a[i] = a[nextInt];
            a[nextInt] = t;
            --i;
        }
        Arrays.sort(a);
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
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
        
        final String nextLine() {
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
