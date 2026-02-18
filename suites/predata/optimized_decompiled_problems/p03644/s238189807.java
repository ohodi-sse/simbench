import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.io.OutputStream;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final OutputWriter outputWriter = new OutputWriter(out);
        new MBBreakNumber();
        final InputReader inputReader2 = inputReader;
        final OutputWriter outputWriter2 = outputWriter;
        InputReader inputReader3;
        int n;
        for (inputReader3 = inputReader2, n = inputReader2.read(); inputReader3.isSpaceChar(n); n = inputReader3.read()) {}
        int n2 = 1;
        if (n == 45) {
            n2 = -1;
            n = inputReader3.read();
        }
        int n3 = 0;
        while (n >= 48 && n <= 57) {
            n3 = n3 * 10 + (n - 48);
            n = inputReader3.read();
            if (inputReader3.isSpaceChar(n)) {
                int i = n3 * n2;
                int n4 = 0;
                while (i >= 0) {
                    for (int j = 0; j < 20; ++j) {
                        if ((int)Math.pow(2.0, j) == i) {
                            outputWriter2.writer.println(i);
                            n4 = 1;
                            break;
                        }
                    }
                    if (n4 == 1) {
                        break;
                    }
                    --i;
                }
                outputWriter.writer.close();
                return;
            }
        }
        throw new InputMismatchException();
    }
    
    static final class MBBreakNumber
    {
        private static void solve$6e5309c7(final InputReader inputReader, final OutputWriter outputWriter) {
            int n;
            for (n = inputReader.read(); inputReader.isSpaceChar(n); n = inputReader.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = inputReader.read();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                n = inputReader.read();
                if (inputReader.isSpaceChar(n)) {
                    int i = n3 * n2;
                    int n4 = 0;
                    while (i >= 0) {
                        for (int j = 0; j < 20; ++j) {
                            if ((int)Math.pow(2.0, j) == i) {
                                outputWriter.writer.println(i);
                                n4 = 1;
                                break;
                            }
                        }
                        if (n4 == 1) {
                            break;
                        }
                        --i;
                    }
                    return;
                }
            }
            throw new InputMismatchException();
        }
    }
    
    static final class OutputWriter
    {
        final PrintWriter writer;
        
        public OutputWriter(final OutputStream out) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
        }
        
        private OutputWriter(final Writer out) {
            this.writer = new PrintWriter(out);
        }
        
        private void close() {
            this.writer.close();
        }
        
        private void printLine(final int x) {
            this.writer.println(x);
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
        
        public final int read() {
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
        
        private int readInt() {
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
        
        public final boolean isSpaceChar(final int n) {
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
