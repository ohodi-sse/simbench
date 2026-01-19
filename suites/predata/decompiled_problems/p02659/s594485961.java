import java.io.IOException;
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
    
    public String readString() {
        final StringBuilder sb = new StringBuilder();
        int n;
        for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
        do {
            sb.append((char)n);
            n = this.read();
        } while (!this.isSpaceChar(n));
        return sb.toString();
    }
    
    public long readLong() {
        int n;
        for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
        int n2 = 1;
        if (n == 45) {
            n2 = -1;
            n = this.read();
        }
        long n3 = 0L;
        do {
            n3 = n3 * 10L + (n - 48);
            n = this.read();
        } while (!this.isSpaceChar(n));
        return n3 * n2;
    }
    
    public boolean isSpaceChar(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
}
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
        new CMultiplication3().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class CMultiplication3
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            System.out.println(inputReader.readLong() * Math.round(Double.parseDouble(inputReader.readString()) * 100.0) / 100L);
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
        
        public String readString() {
            final StringBuilder sb = new StringBuilder();
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            do {
                sb.append((char)n);
                n = this.read();
            } while (!this.isSpaceChar(n));
            return sb.toString();
        }
        
        public long readLong() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            do {
                n3 = n3 * 10L + (n - 48);
                n = this.read();
            } while (!this.isSpaceChar(n));
            return n3 * n2;
        }
        
        public boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
    }
}
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class CMultiplication3
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        System.out.println(inputReader.readLong() * Math.round(Double.parseDouble(inputReader.readString()) * 100.0) / 100L);
    }
}
