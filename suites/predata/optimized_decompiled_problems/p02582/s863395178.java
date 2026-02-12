import java.io.IOException;
import java.util.InputMismatchException;
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
        new ARainySeason();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        InputReader inputReader3;
        int n;
        for (inputReader3 = inputReader2, n = inputReader2.read(); inputReader3.isSpaceChar(n); n = inputReader3.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            if (Character.isValidCodePoint(n)) {
                sb.appendCodePoint(n);
            }
            n = inputReader3.read();
        } while (!inputReader3.isSpaceChar(n));
        final char[] charArray;
        final int length = (charArray = sb.toString().toCharArray()).length;
        int max = 0;
        int a = 0;
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++a;
            }
            else {
                a = 0;
            }
            max = Math.max(a, max);
        }
        printWriter2.println(max);
        printWriter.close();
    }
    
    static final class ARainySeason
    {
        private static void solve$6080e082(InputReader inputReader, final PrintWriter printWriter) {
            int n;
            for (n = (inputReader = inputReader).read(); inputReader.isSpaceChar(n); n = inputReader.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                if (Character.isValidCodePoint(n)) {
                    sb.appendCodePoint(n);
                }
                n = inputReader.read();
            } while (!inputReader.isSpaceChar(n));
            final char[] charArray;
            final int length = (charArray = sb.toString().toCharArray()).length;
            int max = 0;
            int a = 0;
            for (int i = 0; i < length; ++i) {
                if (charArray[i] == 'R') {
                    ++a;
                }
                else {
                    a = 0;
                }
                max = Math.max(a, max);
            }
            printWriter.println(max);
        }
    }
    
    static final class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        public final int read() {
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
        
        public final String nextString() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                if (Character.isValidCodePoint(n)) {
                    sb.appendCodePoint(n);
                }
                n = this.read();
            } while (!this.isSpaceChar(n));
            return sb.toString();
        }
        
        public final boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}
