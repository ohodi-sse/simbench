import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static final int M = 1000000007;
    private long[] fact;
    private long[] invfact;
    
    public Main(final FastScanner fastScanner, final PrintWriter printWriter, final int n) {
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        final boolean[] array = new boolean[201];
        for (int i = 0; i < nextInt2; ++i) {
            array[fastScanner.nextInt()] = true;
        }
        int abs = 200;
        int x = 0;
        for (int j = 0; j <= 200; ++j) {
            if (!array[j] && Math.abs(j - nextInt) < abs) {
                x = j;
                abs = Math.abs(j - nextInt);
            }
        }
        printWriter.println(x);
    }
    
    private void calcFact(final int n) {
        this.fact = new long[n];
        this.invfact = new long[n];
        this.fact[0] = 1L;
        for (int i = 1; i < n; ++i) {
            this.fact[i] = this.fact[i - 1] * i % 1000000007L;
        }
        this.invfact[0] = 1L;
        for (int j = 1; j < n; ++j) {
            this.invfact[j] = this.invfact[j - 1] * this.pow(j, 1000000005) % 1000000007L;
        }
    }
    
    private long pow(final int n, int i) {
        long n2 = 1L;
        long n3 = n;
        while (i > 1) {
            if (i % 2 == 1) {
                n2 = n2 * n3 % 1000000007L;
            }
            n3 = n3 * n3 % 1000000007L;
            i /= 2;
        }
        return n2 * n3 % 1000000007L;
    }
    
    public static void main(final String[] array) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final FastScanner fastScanner = new FastScanner(System.in);
        for (int i = 1; i <= 1; ++i) {
            final Main main = new Main(fastScanner, printWriter, i);
        }
        printWriter.close();
    }
}
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

class FastScanner
{
    private InputStream stream;
    private byte[] buf;
    private int curChar;
    private int numChars;
    
    public FastScanner(final InputStream stream) {
        this.buf = new byte[1024];
        this.stream = stream;
    }
    
    int read() {
        if (this.numChars == -1) {
            throw new InputMismatchException();
        }
        if (this.curChar >= this.numChars) {
            this.curChar = 0;
            try {
                this.numChars = this.stream.read(this.buf);
            }
            catch (final IOException ex) {
                throw new InputMismatchException();
            }
            if (this.numChars <= 0) {
                return -1;
            }
        }
        return this.buf[this.curChar++];
    }
    
    boolean isSpaceChar(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    boolean isEndline(final int n) {
        return n == 10 || n == 13 || n == -1;
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
    
    String next() {
        int codePoint;
        for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isSpaceChar(codePoint));
        return sb.toString();
    }
    
    String nextLine() {
        int codePoint;
        for (codePoint = this.read(); this.isEndline(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isEndline(codePoint));
        return sb.toString();
    }
}
