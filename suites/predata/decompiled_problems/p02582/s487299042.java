import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;





public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ARainySeason().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class ARainySeason
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final String next = inputReader.next();
            int x = 1;
            if (next.contains("SSS")) {
                printWriter.println("0");
            }
            else {
                for (int i = 0; i < next.length() - 1; ++i) {
                    if (next.charAt(i) == 'R' && next.charAt(i + 1) == 'R') {
                        ++x;
                    }
                }
                printWriter.println(x);
            }
        }
    }
    
    static class InputReader
    {
        private final InputStream stream;
        private final byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        public int read() {
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
        
        public String nextString() {
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
        
        public boolean isSpaceChar(final int n) {
            if (this.filter != null) {
                return this.filter.isSpaceChar(n);
            }
            return isWhitespace(n);
        }
        
        public static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public String next() {
            return this.nextString();
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar(final int p0);
        }
    }
}