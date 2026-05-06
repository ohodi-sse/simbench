import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

class InputReader
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
    
    public int readInt() {
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
    
    public String readString() {
        int codePoint;
        for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isSpaceChar(codePoint));
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
        while (n >= 48 && n <= 57) {
            n3 = n3 * 10L + (n - 48);
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
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    public String next() {
        return this.readString();
    }
    
    public interface SpaceCharFilter
    {
        boolean isSpaceChar(final int p0);
    }
}
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final int int1 = new InputReader(System.in).readInt();
        int x = 0;
        for (int i = 0, n = 0; i <= int1; i = (int)Math.pow(2.0, n), x = (int)Math.pow(2.0, n - 1), ++n) {}
        System.out.println(x);
    }
}
