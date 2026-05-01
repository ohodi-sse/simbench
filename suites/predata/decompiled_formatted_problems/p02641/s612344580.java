import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.util.HashSet;
import java.io.OutputStream;
import java.io.PrintWriter;





public class Main
{
    public static void main(final String[] array) {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int nextInt = inputReader.nextInt();
        final int nextInt2 = inputReader.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(inputReader.nextInt());
        }
        Label_0147: {
            if (!set.contains(nextInt)) {
                printWriter.println(nextInt);
            }
            else {
                int n = nextInt;
                int n2 = nextInt;
                do {
                    --n;
                    ++n2;
                    if (!set.contains(n)) {
                        printWriter.println(n);
                        break Label_0147;
                    }
                } while (set.contains(n2));
                printWriter.println(n2);
            }
        }
        printWriter.close();
    }
    
    static class InputReader
    {
        private final InputStream stream;
        private final byte[] buf;
        private int curChar;
        private int snumChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[8192];
            this.stream = stream;
        }
        
        public int snext() {
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
            for (n = this.snext(); this.isSpaceChar(n); n = this.snext()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.snext();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                n = this.snext();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public long nextLong() {
            int n;
            for (n = this.snext(); this.isSpaceChar(n); n = this.snext()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.snext();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = this.snext();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        public String readString() {
            int codePoint;
            for (codePoint = this.snext(); this.isSpaceChar(codePoint); codePoint = this.snext()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.snext();
            } while (!this.isSpaceChar(codePoint));
            return sb.toString();
        }
        
        public String nextLine() {
            int codePoint;
            for (codePoint = this.snext(); this.isSpaceChar(codePoint); codePoint = this.snext()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.snext();
            } while (!this.isEndOfLine(codePoint));
            return sb.toString();
        }
        
        public boolean isSpaceChar(final int n) {
            if (this.filter != null) {
                return this.filter.isSpaceChar(n);
            }
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar(final int p0);
        }
    }
}