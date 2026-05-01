import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.io.PrintWriter;





public class Main
{
    static FastScanner sc;
    static PrintWriter out;
    static int n;
    static String s;
    
    public static void main(final String[] array) {
        Main.out.println(new BigDecimal(Long.toString(Main.sc.nextLong())).multiply(new BigDecimal(Main.sc.next())).longValue());
        Main.out.flush();
    }
    
    static {
        Main.sc = new FastScanner();
        Main.out = new PrintWriter(System.out);
    }
    
    static class FastScanner
    {
        private final InputStream in;
        private final byte[] buffer;
        private int ptr;
        private int buflen;
        
        FastScanner() {
            this.in = System.in;
            this.buffer = new byte[1024];
            this.ptr = 0;
            this.buflen = 0;
        }
        
        private boolean hasNextByte() {
            if (this.ptr < this.buflen) {
                return true;
            }
            this.ptr = 0;
            try {
                this.buflen = this.in.read(this.buffer);
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return this.buflen > 0;
        }
        
        private int readByte() {
            if (this.hasNextByte()) {
                return this.buffer[this.ptr++];
            }
            return -1;
        }
        
        private static boolean isPrintableChar(final int n) {
            return 33 <= n && n <= 126;
        }
        
        private void skipUnprintable() {
            while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
                ++this.ptr;
            }
        }
        
        public boolean hasNext() {
            this.skipUnprintable();
            return this.hasNextByte();
        }
        
        public String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        public long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            long n = 0L;
            boolean b = false;
            int n2 = this.readByte();
            if (n2 == 45) {
                b = true;
                n2 = this.readByte();
            }
            if (n2 < 48 || 57 < n2) {
                throw new NumberFormatException();
            }
            while (48 <= n2 && n2 <= 57) {
                n = n * 10L + (n2 - 48);
                n2 = this.readByte();
            }
            if (n2 == -1 || !isPrintableChar(n2)) {
                return b ? (-n) : n;
            }
            throw new NumberFormatException();
        }
        
        public int nextInt() {
            return (int)this.nextLong();
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        public int[] nextIntArray(final int n, final boolean b) {
            if (b) {
                final int[] array = new int[n + 1];
                for (int i = 1; i <= n; ++i) {
                    array[i] = Main.sc.nextInt();
                }
                return array;
            }
            final int[] array2 = new int[n];
            for (int j = 0; j < n; ++j) {
                array2[j] = Main.sc.nextInt();
            }
            return array2;
        }
        
        public long[] nextLongArray(final int n, final boolean b) {
            if (b) {
                final long[] array = new long[n + 1];
                for (int i = 1; i <= n; ++i) {
                    array[i] = Main.sc.nextLong();
                }
                return array;
            }
            final long[] array2 = new long[n];
            for (int j = 0; j < n; ++j) {
                array2[j] = Main.sc.nextLong();
            }
            return array2;
        }
    }
}