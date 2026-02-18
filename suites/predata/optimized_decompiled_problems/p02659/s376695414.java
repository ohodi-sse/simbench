import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
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
        new CMultiplication3();
        final InputReader inputReader2 = inputReader;
        final OutputWriter outputWriter2 = outputWriter;
        final InputReader inputReader3 = inputReader2;
        InputReader inputReader4;
        int n;
        for (inputReader4 = inputReader2, n = inputReader2.read(); inputReader4.isSpaceChar(n); n = inputReader4.read()) {}
        int n2 = 1;
        if (n == 45) {
            n2 = -1;
            n = inputReader4.read();
        }
        long n3 = 0L;
        while (n >= 48 && n <= 57) {
            n3 = n3 * 10L + (n - 48);
            n = inputReader4.read();
            if (inputReader4.isSpaceChar(n)) {
                final long n4 = n3 * n2;
                InputReader inputReader5;
                int n5;
                for (n5 = (inputReader5 = inputReader3).read(); inputReader5.isSpaceChar(n5); n5 = inputReader5.read()) {}
                final StringBuilder sb = new StringBuilder();
                do {
                    if (Character.isValidCodePoint(n5)) {
                        sb.appendCodePoint(n5);
                    }
                    n5 = inputReader5.read();
                } while (!inputReader5.isSpaceChar(n5));
                outputWriter2.writer.println(n4 * Long.parseLong(sb.toString().replace(".", "")) / 100L);
                outputWriter.writer.close();
                return;
            }
        }
        throw new InputMismatchException();
    }
    
    static final class CMultiplication3
    {
        private static void solve$6e5309c7(final InputReader inputReader, final OutputWriter outputWriter) {
            int n;
            for (n = inputReader.read(); inputReader.isSpaceChar(n); n = inputReader.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = inputReader.read();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = inputReader.read();
                if (inputReader.isSpaceChar(n)) {
                    final long n4 = n3 * n2;
                    int n5;
                    for (n5 = inputReader.read(); inputReader.isSpaceChar(n5); n5 = inputReader.read()) {}
                    final StringBuilder sb = new StringBuilder();
                    do {
                        if (Character.isValidCodePoint(n5)) {
                            sb.appendCodePoint(n5);
                        }
                        n5 = inputReader.read();
                    } while (!inputReader.isSpaceChar(n5));
                    outputWriter.writer.println(n4 * Long.parseLong(sb.toString().replace(".", "")) / 100L);
                    return;
                }
            }
            throw new InputMismatchException();
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
        
        private long readLong() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = this.read();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private String readString() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                if (Character.isValidCodePoint(n)) {
                    sb.appendCodePoint(n);
                }
                n = this.read();
            } while (!this.isSpaceChar(n));
            return sb.toString();
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
        
        private void printLine(final long x) {
            this.writer.println(x);
        }
    }
}
