import java.math.BigDecimal;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

class AtCoder
{
    String A;
    String B;
    
    AtCoder(final FastScanner fastScanner) {
        this.A = fastScanner.next();
        this.B = fastScanner.next();
    }
    
    void solve(final PrintWriter printWriter) {
        printWriter.println(new BigDecimal(this.A).multiply(new BigDecimal(this.B)).setScale(0, 1));
    }
}
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

class FastScanner
{
    private final InputStream in;
    private final byte[] buffer;
    private int ptr;
    private int buflen;
    
    FastScanner() {
        this.in = System.in;
        this.buffer = new byte[1024];
        this.ptr = 0;
        this.buflen = 0;
    }
    
    private boolean hasNextByte() {
        if (this.ptr < this.buflen) {
            return true;
        }
        this.ptr = 0;
        try {
            this.buflen = this.in.read(this.buffer);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return this.buflen > 0;
    }
    
    private int readByte() {
        if (this.hasNextByte()) {
            return this.buffer[this.ptr++];
        }
        return -1;
    }
    
    private static boolean isPrintableChar(final int n) {
        return 33 <= n && n <= 126;
    }
    
    public boolean hasNext() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
        return this.hasNextByte();
    }
    
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        return sb.toString();
    }
    
    public long nextLong() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        long n = 0L;
        boolean b = false;
        int n2 = this.readByte();
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        if (n2 < 48 || 57 < n2) {
            throw new NumberFormatException();
        }
        while (48 <= n2 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = this.readByte();
        }
        if (n2 == -1 || !isPrintableChar(n2)) {
            return b ? (-n) : n;
        }
        throw new NumberFormatException();
    }
    
    public int nextInt() {
        final long nextLong = this.nextLong();
        if (nextLong < -2147483648L || nextLong > 2147483647L) {
            throw new NumberFormatException();
        }
        return (int)nextLong;
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
}
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        new AtCoder(fastScanner).solve(printWriter);
        printWriter.flush();
    }
}
