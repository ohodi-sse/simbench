import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Random;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    public static void main(final String[] array) {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final Random random = new Random();
        int n = 1;
        while (n-- > 0) {
            printWriter.println(new BigDecimal(inputReader.nextLine()).multiply(new BigDecimal(inputReader.nextLong())).longValue());
        }
        printWriter.close();
    }
    
    static class InputReader
    {
        private final InputStream stream;
        private final byte[] buf;
        private int curChar;
        private int snumChars;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[8192];
            this.stream = stream;
        }
        
        public int read() {
            if (this.snumChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.snumChars) {
                this.curChar = 0;
                try {
                    this.snumChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.snumChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }
        
        public int nextInt() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            do {
                n3 = n3 * 10 + (n - 48);
                n = this.read();
            } while (!this.isSpaceChar(n));
            return n3 * n2;
        }
        
        public long nextLong() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            do {
                n3 = n3 * 10L + (n - 48);
                n = this.read();
            } while (!this.isSpaceChar(n));
            return n3 * n2;
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public static int[] shuffle(final int[] array, final Random random) {
            for (int i = 0, length = array.length; i < length; ++i) {
                final int n = random.nextInt(length - i) + i;
                final int n2 = array[i];
                array[i] = array[n];
                array[n] = n2;
            }
            return array;
        }
        
        public String readString() {
            int codePoint;
            for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.read();
            } while (!this.isSpaceChar(codePoint));
            return sb.toString();
        }
        
        public String nextLine() {
            int codePoint;
            for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.read();
            } while (!this.isEndOfLine(codePoint));
            return sb.toString();
        }
        
        public boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
    }
}