import java.util.InputMismatchException;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next = scanner.next();
        final String s = next + scanner.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            final String s2 = s;
            final int beginIndex = i;
            if (s2.substring(beginIndex, beginIndex + 1).equals(s.substring(next.length() + i, next.length() + i + 1))) {
                ++x;
            }
        }
        printWriter.println(x);
        scanner.close();
        printWriter.close();
    }
    
    static final class FastScanner
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        private FastScanner(final InputStream stream) {
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
        
        private int nextInt() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                n = this.read();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private String nextString() {
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
        
        private boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            int i = 0;
        Label_0006:
            while (i < n) {
                final int[] array2 = array;
                final int n2 = i;
                int n3;
                for (n3 = this.read(); this.isSpaceChar(n3); n3 = this.read()) {}
                int n4 = 1;
                if (n3 == 45) {
                    n4 = -1;
                    n3 = this.read();
                }
                int n5 = 0;
                while (n3 >= 48 && n3 <= 57) {
                    n5 = n5 * 10 + (n3 - 48);
                    n3 = this.read();
                    if (this.isSpaceChar(n3)) {
                        array2[n2] = n5 * n4;
                        ++i;
                        continue Label_0006;
                    }
                }
                throw new InputMismatchException();
            }
            return array;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}
