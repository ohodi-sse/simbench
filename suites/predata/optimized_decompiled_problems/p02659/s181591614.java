import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

final class FastScanner
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
    
    final int readByte() {
        if (this.hasNextByte()) {
            return this.buffer[this.ptr++];
        }
        return -1;
    }
    
    static boolean isPrintableChar(final int n) {
        return 33 <= n && n <= 126;
    }
    
    public final boolean hasNext() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
        return this.hasNextByte();
    }
    
    private String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        return sb.toString();
    }
    
    public final long nextLong() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        long n = 0L;
        boolean b = false;
        int n2;
        if ((n2 = this.readByte()) == 45) {
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
        if (n2 != -1 && isPrintableChar(n2)) {
            throw new NumberFormatException();
        }
        if (b) {
            return -n;
        }
        return n;
    }
    
    private int nextInt() {
        final long nextLong;
        if ((nextLong = this.nextLong()) < -2147483648L || nextLong > 2147483647L) {
            throw new NumberFormatException();
        }
        return (int)nextLong;
    }
    
    public final double nextDouble() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        return Double.parseDouble(sb.toString());
    }
}
import java.util.Arrays;
import java.util.NoSuchElementException;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        new Main();
        final FastScanner fastScanner;
        final long nextLong = (fastScanner = new FastScanner()).nextLong();
        if (!fastScanner.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = fastScanner.readByte(); FastScanner.isPrintableChar(codePoint); codePoint = fastScanner.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        System.out.println(nextLong * Math.round(Double.parseDouble(sb.toString()) * 100.0) / 100L);
    }
    
    private static void run() {
        final FastScanner fastScanner;
        final long nextLong = (fastScanner = new FastScanner()).nextLong();
        final FastScanner fastScanner2;
        if (!(fastScanner2 = fastScanner).hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = fastScanner2.readByte(); FastScanner.isPrintableChar(codePoint); codePoint = fastScanner2.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        System.out.println(nextLong * Math.round(Double.parseDouble(sb.toString()) * 100.0) / 100L);
    }
    
    private static void tr(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
}
