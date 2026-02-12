import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastScanner fastScanner = new FastScanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB();
        final FastScanner fastScanner2 = fastScanner;
        final PrintWriter printWriter2 = printWriter;
        final FastScanner fastScanner3 = fastScanner2;
        long n = 0L;
        int n2;
        for (n2 = fastScanner3.readByte(); FastScanner.isSpaceChar(n2); n2 = fastScanner3.readByte()) {}
        final boolean b;
        if (b = (n2 == 45)) {
            n2 = fastScanner3.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = fastScanner3.readByte();
        }
        if (!FastScanner.isSpaceChar(n2)) {
            throw new NumberFormatException();
        }
        final long n3;
        if ((n3 = (b ? (-n) : n)) < -2147483648L || n3 > 2147483647L) {
            throw new NumberFormatException();
        }
        int n4;
        int x;
        for (n4 = (int)n3, x = 1; x << 1 <= n4; x <<= 1) {}
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class TaskB
    {
        private static void solve$2eaeaa57(FastScanner fastScanner, final PrintWriter printWriter) {
            fastScanner = (fastScanner = fastScanner);
            long n = 0L;
            int n2;
            for (n2 = fastScanner.readByte(); FastScanner.isSpaceChar(n2); n2 = fastScanner.readByte()) {}
            final boolean b;
            if (b = (n2 == 45)) {
                n2 = fastScanner.readByte();
            }
            while (n2 >= 48 && n2 <= 57) {
                n = n * 10L + (n2 - 48);
                n2 = fastScanner.readByte();
            }
            if (!FastScanner.isSpaceChar(n2)) {
                throw new NumberFormatException();
            }
            final long n3;
            if ((n3 = (b ? (-n) : n)) < -2147483648L || n3 > 2147483647L) {
                throw new NumberFormatException();
            }
            int n4;
            int x;
            for (n4 = (int)n3, x = 1; x << 1 <= n4; x <<= 1) {}
            printWriter.println(x);
        }
    }
    
    static final class FastScanner
    {
        private InputStream in;
        private byte[] buffer;
        private int bufPointer;
        private int bufLength;
        
        public FastScanner(final InputStream in) {
            this.buffer = new byte[1024];
            this.in = in;
        }
        
        final int readByte() {
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
        
        static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private long nextLong() {
            long n = 0L;
            int n2;
            for (n2 = this.readByte(); isSpaceChar(n2); n2 = this.readByte()) {}
            final boolean b;
            if (b = (n2 == 45)) {
                n2 = this.readByte();
            }
            while (n2 >= 48 && n2 <= 57) {
                n = n * 10L + (n2 - 48);
                n2 = this.readByte();
            }
            if (!isSpaceChar(n2)) {
                throw new NumberFormatException();
            }
            if (b) {
                return -n;
            }
            return n;
        }
        
        public final int nextInt() {
            long n = 0L;
            int n2;
            for (n2 = this.readByte(); isSpaceChar(n2); n2 = this.readByte()) {}
            final boolean b;
            if (b = (n2 == 45)) {
                n2 = this.readByte();
            }
            while (n2 >= 48 && n2 <= 57) {
                n = n * 10L + (n2 - 48);
                n2 = this.readByte();
            }
            if (!isSpaceChar(n2)) {
                throw new NumberFormatException();
            }
            final long n3;
            if ((n3 = (b ? (-n) : n)) < -2147483648L || n3 > 2147483647L) {
                throw new NumberFormatException();
            }
            return (int)n3;
        }
    }
}
