import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    static final long MOD = 998244353L;
    
    public static void main(final String[] array) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final InputReader inputReader = new InputReader(System.in);
        final long nextLong = inputReader.nextLong();
        final char[] charArray = inputReader.next().toCharArray();
        System.out.println(nextLong * (Integer.parseInt(String.valueOf(charArray[0])) * 100 + Integer.parseInt(String.valueOf(charArray[2])) * 10 + Integer.parseInt(String.valueOf(charArray[3]))) / 100L);
    }
    
    static class InputReader
    {
        private InputStream in;
        private byte[] buffer;
        private int curbuf;
        private int lenbuf;
        
        public InputReader(final InputStream in) {
            this.buffer = new byte[1024];
            this.in = in;
            final int n = 0;
            this.lenbuf = n;
            this.curbuf = n;
        }
        
        public boolean hasNextByte() {
            if (this.curbuf >= this.lenbuf) {
                this.curbuf = 0;
                try {
                    this.lenbuf = this.in.read(this.buffer);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.lenbuf <= 0) {
                    return false;
                }
            }
            return true;
        }
        
        private int readByte() {
            if (this.hasNextByte()) {
                return this.buffer[this.curbuf++];
            }
            return -1;
        }
        
        private boolean isSpaceChar(final int n) {
            return n < 33 || n > 126;
        }
        
        private void skip() {
            while (this.hasNextByte() && this.isSpaceChar(this.buffer[this.curbuf])) {
                ++this.curbuf;
            }
        }
        
        public boolean hasNext() {
            this.skip();
            return this.hasNextByte();
        }
        
        public String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.readByte(); !this.isSpaceChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            int n;
            for (n = this.readByte(); this.isSpaceChar(n); n = this.readByte()) {}
            boolean b = false;
            if (n == 45) {
                b = true;
                n = this.readByte();
            }
            int n2 = 0;
            while (n >= 48 && n <= 57) {
                n2 = n2 * 10 + n - 48;
                n = this.readByte();
                if (this.isSpaceChar(n)) {
                    return b ? (-n2) : n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            int n;
            for (n = this.readByte(); this.isSpaceChar(n); n = this.readByte()) {}
            boolean b = false;
            if (n == 45) {
                b = true;
                n = this.readByte();
            }
            long n2 = 0L;
            while (n >= 48 && n <= 57) {
                n2 = n2 * 10L + n - 48L;
                n = this.readByte();
                if (this.isSpaceChar(n)) {
                    return b ? (-n2) : n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
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
        
        public char[][] nextCharMap(final int n, final int n2) {
            final char[][] array = new char[n][n2];
            for (int i = 0; i < n; ++i) {
                array[i] = this.next().toCharArray();
            }
            return array;
        }
    }
}