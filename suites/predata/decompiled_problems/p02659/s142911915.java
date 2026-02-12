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

public class Main
{
    static long MOD;
    static long[] fac;
    static int[][] dir;
    static long lMax;
    static int iMax;
    static HashMap<Long, Long> memo;
    static int n;
    static int m;
    static int[][] mat;
    public static PrintWriter out;
    
    public static void main(final String[] array) {
        final MyScanner myScanner = new MyScanner();
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = 1;
        while (n-- > 0) {
            Main.out.println(myScanner.nextLong() * (long)(100.0 * myScanner.nextDouble() + 0.001) / 100L);
        }
        Main.out.close();
    }
    
    public static long C(final int n, final int n2) {
        if (n2 == 0 || n2 == n) {
            return 1L;
        }
        if (n2 > n || n2 < 0) {
            return 0L;
        }
        return Main.fac[n] * quickPOW(Main.fac[n2] * Main.fac[n - n2] % Main.MOD, Main.MOD - 2L) % Main.MOD;
    }
    
    public static long quickPOW(long n, long n2) {
        long n3 = 1L;
        while (n2 > 0L) {
            if (n2 % 2L == 1L) {
                n3 = n3 * n % Main.MOD;
            }
            n = n * n % Main.MOD;
            n2 >>= 1;
        }
        return n3;
    }
    
    public static int gcd(final int n, final int n2) {
        if (n % n2 == 0) {
            return n2;
        }
        return gcd(n2, n % n2);
    }
    
    public static long gcd(final long n, final long n2) {
        if (n % n2 == 0L) {
            return n2;
        }
        return gcd(n2, n % n2);
    }
    
    public static long solve(final long n) {
        return 0L;
    }
    
    static {
        Main.MOD = 1000000007L;
        Main.dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Main.lMax = 4557430888798830399L;
        Main.iMax = 1061109567;
        Main.memo = new HashMap<Long, Long>();
    }
    
    public static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
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
