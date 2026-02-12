import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    static FastScanner sc;
    private static PrintWriter out;
    private static int n;
    private static String s;
    
    private static void main$3231c38a() {
        Main.s = Main.sc.next();
        int n = 0;
        if (Main.s.charAt(0) == 'R') {
            ++n;
        }
        if (Main.s.charAt(1) == 'R') {
            n += 2;
        }
        if (Main.s.charAt(2) == 'R') {
            n += 4;
        }
        Label_0134: {
            if (n != 0) {
                if (n == 1 || n == 2 || n == 4 || n == 5) {
                    Main.out.println(1);
                    break Label_0134;
                }
                if (n == 3 || n == 6) {
                    Main.out.println(2);
                    break Label_0134;
                }
                if (n == 7) {
                    Main.out.println(3);
                    break Label_0134;
                }
            }
            Main.out.println(0);
        }
        Main.out.flush();
    }
    
    static {
        Main.sc = new FastScanner();
        Main.out = new PrintWriter(System.out);
    }
    
    static final class FastScanner
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
        
        private boolean hasNext() {
            while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
                ++this.ptr;
            }
            return this.hasNextByte();
        }
        
        public final String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            long n = 0L;
            boolean b = false;
            int n2;
            if ((n2 = this.readByte()) == 45) {
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
            if (n2 != -1 && isPrintableChar(n2)) {
                throw new NumberFormatException();
            }
            if (b) {
                return -n;
            }
            return n;
        }
        
        private int nextInt() {
            return (int)this.nextLong();
        }
        
        private static int[] nextIntArray(final int n, final boolean b) {
            if (b) {
                final int[] array = new int[n + 1];
                for (int i = 1; i <= n; ++i) {
                    array[i] = (int)Main.sc.nextLong();
                }
                return array;
            }
            final int[] array2 = new int[n];
            for (int j = 0; j < n; ++j) {
                array2[j] = (int)Main.sc.nextLong();
            }
            return array2;
        }
        
        private static long[] nextLongArray(final int n, final boolean b) {
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
        
        private static double[] nextDoubleArray(final int n, final boolean b) {
            if (b) {
                final double[] array = new double[n + 1];
                for (int i = 1; i <= n; ++i) {
                    array[i] = Double.parseDouble(Main.sc.next());
                }
                return array;
            }
            final double[] array2 = new double[n];
            for (int j = 0; j < n; ++j) {
                array2[j] = Double.parseDouble(Main.sc.next());
            }
            return array2;
        }
    }
}
