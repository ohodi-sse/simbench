import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

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
    
    public String nextString() {
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
// 
// Decompiled by Procyon v0.6.0
// 

public interface SpaceCharFilter
{
    boolean isSpaceChar(final int p0);
}
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
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ARainySeason().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class ARainySeason
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final char[] charArray = inputReader.nextString().toCharArray();
            final int length = charArray.length;
            int max = 0;
            int a = 0;
            for (int i = 0; i < length; ++i) {
                if (charArray[i] == 'R') {
                    ++a;
                }
                else {
                    a = 0;
                }
                max = Math.max(a, max);
            }
            printWriter.println(max);
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
        
        public String nextString() {
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
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class ARainySeason
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        final char[] charArray = inputReader.nextString().toCharArray();
        final int length = charArray.length;
        int max = 0;
        int a = 0;
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++a;
            }
            else {
                a = 0;
            }
            max = Math.max(a, max);
        }
        printWriter.println(max);
    }
}
