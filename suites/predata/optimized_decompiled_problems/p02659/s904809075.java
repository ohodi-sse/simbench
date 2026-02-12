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
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        InputReader inputReader3;
        String s;
        for (inputReader3 = inputReader2, s = inputReader2.readLine0(); s.trim().length() == 0; s = inputReader3.readLine0()) {}
        final String[] split = s.split(" ");
        printWriter2.println(String.valueOf(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$6080e082(InputReader inputReader, final PrintWriter printWriter) {
            String s;
            for (s = (inputReader = inputReader).readLine0(); s.trim().length() == 0; s = inputReader.readLine0()) {}
            final String[] split = s.split(" ");
            printWriter.println(String.valueOf(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
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
        
        final String readLine0() {
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
}
