import java.io.IOException;
import java.util.InputMismatchException;
import java.util.HashSet;
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
            final int nextInt = inputReader.nextInt();
            final int nextInt2 = inputReader.nextInt();
            if (nextInt2 != 0) {
                final HashSet set = new HashSet();
                for (int i = 0; i < nextInt2; ++i) {
                    set.add(inputReader.nextInt());
                }
                int n2 = 1;
                while (true) {
                    while (set.contains(nextInt)) {
                        int x;
                        if (!set.contains(nextInt - n2)) {
                            x = nextInt - n2;
                        }
                        else {
                            if (set.contains(nextInt + n2)) {
                                ++n2;
                                continue;
                            }
                            x = nextInt + n2;
                        }
                        printWriter.println(x);
                        return;
                    }
                    int x = nextInt;
                    continue;
                }
            }
            printWriter.println(nextInt);
        }
    }
    
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        public int read() {
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
        
        public int nextInt() {
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
        
        public boolean isSpaceChar(final int n) {
            if (this.filter != null) {
                return this.filter.isSpaceChar(n);
            }
            return isWhitespace(n);
        }
        
        public static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar(final int p0);
        }
    }
}
