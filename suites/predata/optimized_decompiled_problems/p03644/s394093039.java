import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

final class InputReader
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
    
    private String readString() {
        int codePoint;
        for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isSpaceChar(codePoint));
        return sb.toString();
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
    
    public final boolean isSpaceChar(final int n) {
        final SpaceCharFilter filter = this.filter;
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    private String next() {
        int codePoint;
        for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isSpaceChar(codePoint));
        return sb.toString();
    }
    
    public interface SpaceCharFilter
    {
        boolean isSpaceChar$134632();
    }
}
import java.io.IOException;
import java.util.InputMismatchException;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        InputReader inputReader;
        int n;
        for (n = (inputReader = new InputReader(System.in)).read(); inputReader.isSpaceChar(n); n = inputReader.read()) {}
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
                final int n4 = n3 * n2;
                int x = 0;
                for (int i = 0, n5 = 0; i <= n4; i = (int)Math.pow(2.0, n5), x = (int)Math.pow(2.0, n5 - 1), ++n5) {}
                System.out.println(x);
                return;
            }
        }
        throw new InputMismatchException();
    }
}
