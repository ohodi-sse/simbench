import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.Arrays;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static boolean isDebug;
    
    private static void main$3231c38a() throws Exception {
        int nextInt;
        int i;
        for (nextInt = new Scanner(System.in).nextInt(), i = 2; i <= nextInt; i <<= 1) {}
        System.out.println(i / 2);
    }
    
    private static void debug(final Object... a) {
        if (Main.isDebug) {
            System.err.println(Arrays.deepToString(a));
        }
    }
    
    static {
        Main.isDebug = (System.getProperty("sun.desktop") != null);
    }
    
    public static final class Scanner
    {
        private BufferedInputStream inputStream;
        private StringBuilder buffer;
        
        public Scanner(final InputStream in) {
            this.buffer = new StringBuilder();
            this.inputStream = new BufferedInputStream(in);
        }
        
        public final int nextInt() throws IOException {
            int n = 0;
            int n2 = 1;
            int n3;
            if ((n3 = this.skip()) == 45) {
                n2 = -1;
                n3 = this.inputStream.read();
            }
            do {
                n = n * 10 + n2 * (n3 - 48);
            } while ((n3 = this.inputStream.read()) > 32);
            return n;
        }
        
        private void fill(final int[] array) throws IOException {
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.nextInt();
            }
        }
        
        private void fill(final int[] array, final int[] array2) throws IOException {
            if (array.length != array2.length) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.nextInt();
                array2[i] = this.nextInt();
            }
        }
        
        private long nextLong() throws IOException {
            long n = 0L;
            int n2 = 1;
            int n3;
            if ((n3 = this.skip()) == 45) {
                n2 = -1;
                n3 = this.inputStream.read();
            }
            do {
                n = n * 10L + n2 * (n3 - 48);
            } while ((n3 = this.inputStream.read()) > 32);
            return n;
        }
        
        private void fill(final long[] array) throws IOException {
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.nextLong();
            }
        }
        
        private void fill(final long[] array, final long[] array2) throws IOException {
            if (array.length != array2.length) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.nextLong();
                array2[i] = this.nextLong();
            }
        }
        
        private long[] nextLong(final int n) throws IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        private String next() throws IOException {
            int n = this.skip();
            do {
                this.buffer.append((char)n);
            } while ((n = this.inputStream.read()) > 32);
            final String string = this.buffer.toString();
            this.buffer.delete(0, this.buffer.length());
            return string;
        }
        
        private int skip() throws IOException {
            int read;
            while ((read = this.inputStream.read()) <= 32) {}
            return read;
        }
    }
}
