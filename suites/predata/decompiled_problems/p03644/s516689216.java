import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    final int _intMax = Integer.MAX_VALUE;
    final int _intMin = Integer.MIN_VALUE;
    final long _longMax = Long.MAX_VALUE;
    final long _longMin = Long.MIN_VALUE;
    static boolean bElapsed;
    static BufferedReader _in;
    static PrintWriter _out;
    
    void solve() {
        int num;
        int i;
        for (num = this.readNum(), i = 1; i <= num; i *= 2) {}
        if (i > num) {
            i /= 2;
        }
        this.pln(i);
    }
    
    int abs(final int n) {
        return (n >= 0) ? n : (-n);
    }
    
    long abs(final long n) {
        return (n >= 0L) ? n : (-n);
    }
    
    int max(final int n, final int n2) {
        return (n > n2) ? n : n2;
    }
    
    long max(final long n, final long n2) {
        return (n > n2) ? n : n2;
    }
    
    int min(final int n, final int n2) {
        return (n < n2) ? n : n2;
    }
    
    long min(final long n, final long n2) {
        return (n < n2) ? n : n2;
    }
    
    int pint(final String s) {
        return Integer.parseInt(s);
    }
    
    long plong(final String s) {
        return Long.parseLong(s);
    }
    
    String readLine() {
        try {
            return Main._in.readLine();
        }
        catch (final IOException cause) {
            throw new RuntimeException(cause);
        }
    }
    
    int readNum() {
        return this.pint(this.readLine());
    }
    
    long readLong() {
        return this.plong(this.readLine());
    }
    
    String[] readFlds() {
        return this.readLine().split(" ");
    }
    
    int[] readNums() {
        final String[] flds = this.readFlds();
        final int[] array = new int[flds.length];
        for (int i = 0; i < flds.length; ++i) {
            array[i] = this.pint(flds[i]);
        }
        return array;
    }
    
    long[] readLongs() {
        final String[] flds = this.readFlds();
        final long[] array = new long[flds.length];
        for (int i = 0; i < flds.length; ++i) {
            array[i] = this.pint(flds[i]);
        }
        return array;
    }
    
    void p(final char c) {
        Main._out.print(c);
    }
    
    void pln(final char x) {
        Main._out.println(x);
    }
    
    void p(final double d) {
        Main._out.print(d);
    }
    
    void pln(final double x) {
        Main._out.println(x);
    }
    
    void p(final long l) {
        Main._out.print(l);
    }
    
    void pln(final long x) {
        Main._out.println(x);
    }
    
    void p(final String s) {
        Main._out.print(s);
    }
    
    void pln(final String x) {
        Main._out.println(x);
    }
    
    public static void main(final String[] array) {
        final long currentTimeMillis = System.currentTimeMillis();
        Main._in = new BufferedReader(new InputStreamReader(System.in));
        Main._out = new PrintWriter(System.out);
        new Main().solve();
        Main._out.flush();
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (Main.bElapsed) {
            System.err.println(currentTimeMillis2 - currentTimeMillis + "ms");
        }
    }
    
    static {
        Main.bElapsed = false;
    }
}
