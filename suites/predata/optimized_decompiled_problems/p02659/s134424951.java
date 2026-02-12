import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

final class FastScanner
{
    private InputStream stream;
    private byte[] buf;
    private int curChar;
    private int numChars;
    
    public FastScanner(final InputStream stream) {
        this.buf = new byte[1024];
        this.stream = stream;
    }
    
    private int read() {
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
    
    private static boolean isSpaceChar(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    private static boolean isEndline(final int n) {
        return n == 10 || n == 13 || n == -1;
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
    
    final String next() {
        int codePoint;
        for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
        } while (!isSpaceChar(codePoint = this.read()));
        return sb.toString();
    }
    
    private String nextLine() {
        int codePoint;
        for (codePoint = this.read(); isEndline(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
        } while (!isEndline(codePoint = this.read()));
        return sb.toString();
    }
}
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static final int M = 1000000007;
    
    private Main(final FastScanner fastScanner, final PrintWriter printWriter) {
        final long long1 = Long.parseLong(fastScanner.next());
        final String[] split = fastScanner.next().split("\\.");
        printWriter.println(long1 * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
    }
    
    private static long pow(final int n, int i) {
        long n2 = 1L;
        long n3 = n;
        while (i > 1) {
            if (i % 2 == 1) {
                n2 = n2 * n3 % 1000000007L;
            }
            final long n4 = n3;
            n3 = n4 * n4 % 1000000007L;
            i /= 2;
        }
        return n2 * n3 % 1000000007L;
    }
    
    private static void main$3231c38a() {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final FastScanner fastScanner = new FastScanner(System.in);
        for (int i = 1; i <= 1; ++i) {
            new Main(fastScanner, printWriter);
        }
        printWriter.close();
    }
}
