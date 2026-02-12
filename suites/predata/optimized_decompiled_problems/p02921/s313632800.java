import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
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
        new ATenki();
        final InputReader inputReader2 = inputReader;
        final OutputWriter outputWriter2 = outputWriter;
        final InputReader inputReader3 = inputReader2;
        final String line = inputReader2.readLine();
        final String line2 = inputReader3.readLine();
        int x = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == line2.charAt(i)) {
                ++x;
            }
        }
        outputWriter2.writer.println(x);
        outputWriter.writer.close();
    }
    
    static final class ATenki
    {
        private static void solve$6e5309c7(final InputReader inputReader, final OutputWriter outputWriter) {
            final String line = inputReader.readLine();
            final String line2 = inputReader.readLine();
            int x = 0;
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == line2.charAt(i)) {
                    ++x;
                }
            }
            outputWriter.writer.println(x);
        }
    }
    
    static final class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        
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
        
        private String readLine0() {
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.read(); codePoint != 10 && codePoint != -1; codePoint = this.read()) {
                if (codePoint != 13) {
                    sb.appendCodePoint(codePoint);
                }
            }
            return sb.toString();
        }
        
        public final String readLine() {
            String s;
            for (s = this.readLine0(); s.trim().length() == 0; s = this.readLine0()) {}
            return s;
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
        
        public final void printLine(final int x) {
            this.writer.println(x);
        }
    }
}
