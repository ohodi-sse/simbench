import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

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







public class Main
{
    private static final int M = 1000000007;
    
    public Main(final FastScanner fastScanner, final PrintWriter printWriter, final int n) {
        final long nextLong = fastScanner.nextLong();
        final String[] split = fastScanner.next().split("\\.");
        printWriter.println(nextLong * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
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