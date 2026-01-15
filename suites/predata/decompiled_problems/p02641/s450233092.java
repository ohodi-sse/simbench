import java.io.OutputStream;
import java.util.HashSet;
import java.io.PrintWriter;
import java.util.Set;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    Set<Integer> set;
    private PrintWriter out;
    private FastScanner scan;
    
    public Main() {
        this.set = new HashSet<Integer>();
        this.out = new PrintWriter(System.out);
        this.scan = new FastScanner();
    }
    
    public static void main(final String[] array) {
        final Main main = new Main();
        main.solve();
        main.out.close();
    }
    
    public void solve() {
        final int ni = this.ni();
        final int ni2 = this.ni();
        if (ni2 == 0) {
            this.out.println(ni);
            return;
        }
        for (int i = 0; i < ni2; ++i) {
            this.set.add(this.ni());
        }
        int x = 0;
        int abs = 200;
        for (int j = 0; j <= 101; ++j) {
            if (!this.set.contains(j)) {
                if (abs > Math.abs(j - ni)) {
                    abs = Math.abs(j - ni);
                    x = j;
                }
            }
        }
        this.out.println(x);
    }
    
    int ni() {
        return this.scan.nextInt();
    }
    
    int[] ni(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ni();
        }
        return array;
    }
    
    int[][] ni(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.ni();
            }
        }
        return array;
    }
    
    long nl() {
        return this.scan.nextLong();
    }
    
    long[] nl(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nl();
        }
        return array;
    }
    
    long[][] nl(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nl();
            }
        }
        return array;
    }
    
    String ns() {
        return this.scan.next();
    }
    
    String[] ns(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ns();
        }
        return array;
    }
    
    String[][] ns(final int n, final int n2) {
        final String[][] array = new String[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.ns();
            }
        }
        return array;
    }
}
