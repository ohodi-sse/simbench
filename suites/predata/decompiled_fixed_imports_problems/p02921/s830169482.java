import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.InputStream;

public class Main
{
    public static void main(final String[] array) {
        final FS fs = new FS();
        final String next = fs.next();
        final String next2 = fs.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    public static void solver() {
    }
    
    static class FS
    {
        private final InputStream in;
        private final byte[] buffer;
        private int ptr;
        private int buflen;
        
        FS() {
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
            return this.hasNextByte() ? this.buffer[this.ptr++] : -1;
        }
        
        private boolean isPrintableChar(final int n) {
            return 33 <= n && n <= 126;
        }
        
        private void skipUnprintable() {
            while (this.hasNextByte() && !this.isPrintableChar(this.buffer[this.ptr])) {
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
            for (int codePoint = this.readByte(); this.isPrintableChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        public int nextInt() {
            return (int)this.nextLong();
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
            if (n2 == -1 || !this.isPrintableChar(n2)) {
                return b ? (-n) : n;
            }
            throw new NumberFormatException();
        }
    }
}