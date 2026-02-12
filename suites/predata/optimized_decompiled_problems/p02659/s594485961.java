import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        InputReader inputReader2;
        int n;
        for (n = (inputReader2 = inputReader).read(); InputReader.isSpaceChar(n); n = inputReader2.read()) {}
        int n2 = 1;
        if (n == 45) {
            n2 = -1;
            n = inputReader2.read();
        }
        long n3 = 0L;
        do {
            n3 = n3 * 10L + (n - 48);
        } while (!InputReader.isSpaceChar(n = inputReader2.read()));
        final long n4 = n3 * n2;
        final InputReader inputReader3 = inputReader;
        final StringBuilder sb = new StringBuilder();
        int n5;
        for (n5 = inputReader3.read(); InputReader.isSpaceChar(n5); n5 = inputReader3.read()) {}
        do {
            sb.append((char)n5);
        } while (!InputReader.isSpaceChar(n5 = inputReader3.read()));
        System.out.println(n4 * Math.round(Double.parseDouble(sb.toString()) * 100.0) / 100L);
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$6080e082(final InputReader inputReader) {
            int n;
            for (n = inputReader.read(); InputReader.isSpaceChar(n); n = inputReader.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = inputReader.read();
            }
            long n3 = 0L;
            do {
                n3 = n3 * 10L + (n - 48);
            } while (!InputReader.isSpaceChar(n = inputReader.read()));
            final long n4 = n3 * n2;
            final StringBuilder sb = new StringBuilder();
            int n5;
            for (n5 = inputReader.read(); InputReader.isSpaceChar(n5); n5 = inputReader.read()) {}
            do {
                sb.append((char)n5);
            } while (!InputReader.isSpaceChar(n5 = inputReader.read()));
            System.out.println(n4 * Math.round(Double.parseDouble(sb.toString()) * 100.0) / 100L);
        }
    }
    
    static final class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        public final int read() {
            if (this.numChars == -1) {
                throw new RuntimeException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new RuntimeException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }
        
        public final String readString() {
            final StringBuilder sb = new StringBuilder();
            int n;
            for (n = this.read(); isSpaceChar(n); n = this.read()) {}
            do {
                sb.append((char)n);
            } while (!isSpaceChar(n = this.read()));
            return sb.toString();
        }
        
        public final long readLong() {
            int n;
            for (n = this.read(); isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            do {
                n3 = n3 * 10L + (n - 48);
            } while (!isSpaceChar(n = this.read()));
            return n3 * n2;
        }
        
        public static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
    }
}
