import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastScanner fastScanner = new FastScanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB().solve(1, fastScanner, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        public void solve(final int n, final FastScanner fastScanner, final PrintWriter printWriter) {
            int nextInt;
            int x;
            for (nextInt = fastScanner.nextInt(), x = 1; x << 1 <= nextInt; x <<= 1) {}
            printWriter.println(x);
        }
    }
    
    static class FastScanner
    {
        private InputStream in;
        private byte[] buffer;
        private int bufPointer;
        private int bufLength;
        
        public FastScanner(final InputStream in) {
            this.buffer = new byte[1024];
            this.in = in;
        }
        
        private int readByte() {
            if (this.bufPointer >= this.bufLength) {
                if (this.bufLength == -1) {
                    throw new InputMismatchException();
                }
                this.bufPointer = 0;
                try {
                    this.bufLength = this.in.read(this.buffer);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.bufLength <= 0) {
                    return -1;
                }
            }
            return this.buffer[this.bufPointer++];
        }
        
        private static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public long nextLong() {
            long n = 0L;
            int n2;
            for (n2 = this.readByte(); isSpaceChar(n2); n2 = this.readByte()) {}
            final boolean b = n2 == 45;
            if (b) {
                n2 = this.readByte();
            }
            while (n2 >= 48 && n2 <= 57) {
                n = n * 10L + (n2 - 48);
                n2 = this.readByte();
            }
            if (!isSpaceChar(n2)) {
                throw new NumberFormatException();
            }
            return b ? (-n) : n;
        }
        
        public int nextInt() {
            final long nextLong = this.nextLong();
            if (nextLong < -2147483648L || nextLong > 2147483647L) {
                throw new NumberFormatException();
            }
            return (int)nextLong;
        }
    }
}
