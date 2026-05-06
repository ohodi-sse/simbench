import java.io.IOException;
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
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CForbiddenList().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class CForbiddenList
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final int int1 = inputReader.readInt();
            final int int2 = inputReader.readInt();
            final boolean[] array = new boolean[201];
            for (int i = 0; i < int2; ++i) {
                array[inputReader.readInt()] = true;
            }
            int abs = Integer.MAX_VALUE;
            int x = 0;
            for (int j = -100; j <= 200; ++j) {
                if (j < 0 || !array[j]) {
                    if (abs > Math.abs(int1 - j)) {
                        abs = Math.abs(int1 - j);
                        x = j;
                    }
                }
            }
            System.out.println(x);
        }
    }
    
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        public int read() {
            if (this.numChars == -1) {
                throw new RuntimeException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new RuntimeException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }
        
        public int readInt() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            do {
                n3 = n3 * 10 + (n - 48);
                n = this.read();
            } while (!this.isSpaceChar(n));
            return n3 * n2;
        }
        
        public boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
    }
}
