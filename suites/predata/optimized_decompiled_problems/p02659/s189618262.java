import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final InputStreamScanner inputStreamScanner = new InputStreamScanner(System.in);
        new Main();
        final InputStreamScanner inputStreamScanner2 = inputStreamScanner;
        printWriter.println(new BigDecimal(inputStreamScanner2.next()).multiply(new BigDecimal(inputStreamScanner2.next())).setScale(0, RoundingMode.DOWN));
        printWriter.flush();
    }
    
    private static void solve(final InputStreamScanner inputStreamScanner, final PrintWriter printWriter) {
        printWriter.println(new BigDecimal(inputStreamScanner.next()).multiply(new BigDecimal(inputStreamScanner.next())).setScale(0, RoundingMode.DOWN));
    }
    
    static final class InputStreamScanner
    {
        private InputStream in;
        private byte[] buf;
        private int len;
        private int off;
        
        InputStreamScanner(final InputStream in) {
            this.buf = new byte[1024];
            this.len = 0;
            this.off = 0;
            this.in = in;
        }
        
        final String next() {
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.skip(); !isSpace(codePoint); codePoint = this.read()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
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
        
        private char nextChar() {
            return (char)this.skip();
        }
        
        private int skip() {
            int read;
            while ((read = this.read()) != -1) {
                if (!isSpace(read)) {
                    return read;
                }
            }
            return -1;
        }
        
        private static boolean isSpace(final int n) {
            return n < 33 || n > 126;
        }
        
        private int read() {
            if (this.len == -1) {
                throw new InputMismatchException("End of Input");
            }
            if (this.off >= this.len) {
                this.off = 0;
                try {
                    this.len = this.in.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException(ex.getMessage());
                }
                if (this.len <= 0) {
                    return -1;
                }
            }
            return this.buf[this.off++];
        }
    }
}
