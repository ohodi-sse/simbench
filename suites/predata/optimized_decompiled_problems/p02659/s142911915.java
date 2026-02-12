import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static long MOD;
    private static long[] fac;
    private static int[][] dir;
    private static long lMax;
    private static int iMax;
    private static HashMap<Long, Long> memo;
    private static int n;
    private static int m;
    private static int[][] mat;
    private static PrintWriter out;
    
    private static void main$3231c38a() {
        final MyScanner myScanner = new MyScanner();
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = 1;
        while (n-- > 0) {
            Main.out.println(Long.parseLong(myScanner.next()) * (long)(Double.parseDouble(myScanner.next()) * 100.0 + 0.001) / 100L);
        }
        Main.out.close();
    }
    
    private static long C(final int n, final int n2) {
        if (n2 == 0 || n2 == n) {
            return 1L;
        }
        if (n2 > n || n2 < 0) {
            return 0L;
        }
        throw new NullPointerException();
    }
    
    private static long quickPOW(long n, long n2) {
        long n3 = 1L;
        while (n2 > 0L) {
            if (n2 % 2L == 1L) {
                n3 = n3 * n % Main.MOD;
            }
            final long n4 = n;
            n = n4 * n4 % Main.MOD;
            n2 >>= 1;
        }
        return n3;
    }
    
    private static int gcd(int n, int n2) {
        while (n % n2 != 0) {
            final int n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n2;
    }
    
    private static long gcd(long n, long n2) {
        while (n % n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n2;
    }
    
    private static long solve$1349e3() {
        return 0L;
    }
    
    static {
        Main.MOD = 1000000007L;
        final int[][] array = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        new HashMap();
    }
    
    public static final class MyScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public MyScanner() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private String nextLine() {
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
