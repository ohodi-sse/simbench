import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final Scanner scanner = new Scanner(System.in);
        final int nextInt;
        if ((nextInt = inputReader.nextInt()) == 1) {
            System.out.println("1");
        }
        else {
            int i;
            for (i = 1; i <= nextInt; i <<= 1) {}
            if (i / 2 == nextInt) {
                System.out.println(nextInt);
            }
            else {
                System.out.println(i / 2);
            }
        }
        printWriter.close();
        scanner.close();
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
        
        private int read() {
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
        
        public final int nextInt() {
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
                array[i] = this.nextInt();
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
        
        private String nextLine() {
            int codePoint;
            for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            int n;
            do {
                sb.appendCodePoint(codePoint);
            } while ((n = (codePoint = this.read())) != 10 && n != 13 && n != -1);
            return sb.toString();
        }
        
        private static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private static boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
    }
}
