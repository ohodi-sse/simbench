import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Random;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        new Random();
        int n = 1;
        while (n-- > 0) {
            InputReader inputReader2;
            int n2;
            for (n2 = (inputReader2 = inputReader).read(); InputReader.isSpaceChar(n2); n2 = inputReader2.read()) {}
            int n3 = 1;
            if (n2 == 45) {
                n3 = -1;
                n2 = inputReader2.read();
            }
            long n4 = 0L;
            do {
                n4 = n4 * 10L + (n2 - 48);
            } while (!InputReader.isSpaceChar(n2 = inputReader2.read()));
            printWriter.println(new BigDecimal(inputReader.nextLine()).multiply(new BigDecimal(n4 * n3)).longValue());
        }
        printWriter.close();
    }
    
    static final class InputReader
    {
        private final InputStream stream;
        private final byte[] buf;
        private int curChar;
        private int snumChars;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[8192];
            this.stream = stream;
        }
        
        public final int read() {
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
        
        private int nextInt() {
            int n;
            for (n = this.read(); isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            do {
                n3 = n3 * 10 + (n - 48);
            } while (!isSpaceChar(n = this.read()));
            return n3 * n2;
        }
        
        private long nextLong() {
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
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                final int[] array2 = array;
                final int n2 = i;
                int n3;
                for (n3 = this.read(); isSpaceChar(n3); n3 = this.read()) {}
                int n4 = 1;
                if (n3 == 45) {
                    n4 = -1;
                    n3 = this.read();
                }
                int n5 = 0;
                do {
                    n5 = n5 * 10 + (n3 - 48);
                } while (!isSpaceChar(n3 = this.read()));
                array2[n2] = n5 * n4;
            }
            return array;
        }
        
        private static int[] shuffle(final int[] array, final Random random) {
            for (int i = 0, length = array.length; i < length; ++i) {
                final int n = random.nextInt(length - i) + i;
                final int n2 = array[i];
                array[i] = array[n];
                array[n] = n2;
            }
            return array;
        }
        
        private String readString() {
            int codePoint;
            for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
            } while (!isSpaceChar(codePoint = this.read()));
            return sb.toString();
        }
        
        public final String nextLine() {
            int codePoint;
            for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            int n;
            do {
                sb.appendCodePoint(codePoint);
            } while ((n = (codePoint = this.read())) != 10 && n != 13 && n != -1);
            return sb.toString();
        }
        
        public static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private static boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
    }
}
