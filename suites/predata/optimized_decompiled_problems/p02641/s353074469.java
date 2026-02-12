import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.HashSet;
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
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CForbiddenList();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final int nextInt = inputReader2.nextInt();
        Label_0182: {
            final int nextInt2;
            if ((nextInt2 = inputReader3.nextInt()) != 0) {
                final HashSet set = new HashSet();
                for (int i = 0; i < nextInt2; ++i) {
                    set.add(inputReader3.nextInt());
                }
                int n = 1;
                while (true) {
                    while (set.contains(nextInt)) {
                        int x;
                        if (!set.contains(nextInt - n)) {
                            x = nextInt - n;
                        }
                        else {
                            if (set.contains(nextInt + n)) {
                                ++n;
                                continue;
                            }
                            x = nextInt + n;
                        }
                        printWriter2.println(x);
                        break Label_0182;
                    }
                    int x = nextInt;
                    continue;
                }
            }
            printWriter2.println(nextInt);
        }
        printWriter.close();
    }
    
    static final class CForbiddenList
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            final int nextInt = inputReader.nextInt();
            final int nextInt2;
            if ((nextInt2 = inputReader.nextInt()) == 0) {
                printWriter.println(nextInt);
                return;
            }
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(inputReader.nextInt());
            }
            int n = 1;
            while (true) {
                while (set.contains(nextInt)) {
                    int x;
                    if (!set.contains(nextInt - n)) {
                        x = nextInt - n;
                    }
                    else {
                        if (set.contains(nextInt + n)) {
                            ++n;
                            continue;
                        }
                        x = nextInt + n;
                    }
                    printWriter.println(x);
                    return;
                }
                int x = nextInt;
                continue;
            }
        }
    }
    
    static final class InputReader
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
        
        private int read() {
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
        
        public final int nextInt() {
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
        
        private boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}
