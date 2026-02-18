import java.io.IOException;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.InputStream;
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
        new TaskA();
        final InputReader inputReader2 = inputReader;
        final OutputWriter outputWriter2 = outputWriter;
        final InputReader inputReader3 = inputReader2;
        final String nextString = inputReader2.nextString();
        final String nextString2 = inputReader3.nextString();
        int x = 0;
        for (int i = 0; i < nextString.length(); ++i) {
            if (nextString.charAt(i) == nextString2.charAt(i)) {
                ++x;
            }
        }
        outputWriter2.writer.println(x);
        outputWriter.writer.close();
    }
    
    static final class TaskA
    {
        private static void solve$6e5309c7(final InputReader inputReader, final OutputWriter outputWriter) {
            final String nextString = inputReader.nextString();
            final String nextString2 = inputReader.nextString();
            int x = 0;
            for (int i = 0; i < nextString.length(); ++i) {
                if (nextString.charAt(i) == nextString2.charAt(i)) {
                    ++x;
                }
            }
            outputWriter.writer.println(x);
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
        
        private void println(final int x) {
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
        
        public final String nextString() {
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
        
        private boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private String next() {
            return this.nextString();
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}
