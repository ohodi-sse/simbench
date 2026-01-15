import java.util.Arrays;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.FileInputStream;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    FileInputStream fs;
    InputStream is;
    PrintWriter out;
    String INPUT;
    private byte[] inbuf;
    public int lenbuf;
    public int ptrbuf;
    
    Main() {
        this.INPUT = "";
        this.inbuf = new byte[1024];
        this.lenbuf = 0;
        this.ptrbuf = 0;
    }
    
    void solve() {
        final String ns = this.ns();
        final String ns2 = this.ns();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (ns.charAt(i) == ns2.charAt(i)) {
                ++x;
            }
        }
        this.out.println(x);
    }
    
    void run() throws Exception {
        this.is = (this.INPUT.isEmpty() ? System.in : new ByteArrayInputStream(this.INPUT.getBytes()));
        this.out = new PrintWriter(System.out);
        final long currentTimeMillis = System.currentTimeMillis();
        this.solve();
        this.out.flush();
        if (!this.INPUT.isEmpty()) {
            this.tr(System.currentTimeMillis() - currentTimeMillis + "ms");
        }
    }
    
    public static void main(final String[] array) throws Exception {
        new Main().run();
    }
    
    private int readByte() {
        if (this.lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (this.ptrbuf >= this.lenbuf) {
            this.ptrbuf = 0;
            try {
                this.lenbuf = this.is.read(this.inbuf);
            }
            catch (final IOException ex) {
                throw new InputMismatchException();
            }
            if (this.lenbuf <= 0) {
                return -1;
            }
        }
        return this.inbuf[this.ptrbuf++];
    }
    
    private boolean isSpaceChar(final int n) {
        return n < 33 || n > 126;
    }
    
    private int skip() {
        int byte1;
        while ((byte1 = this.readByte()) != -1 && this.isSpaceChar(byte1)) {}
        return byte1;
    }
    
    private double nd() {
        return Double.parseDouble(this.ns());
    }
    
    private char nc() {
        return (char)this.skip();
    }
    
    private String ns() {
        int codePoint = this.skip();
        final StringBuilder sb = new StringBuilder();
        while (!this.isSpaceChar(codePoint)) {
            sb.appendCodePoint(codePoint);
            codePoint = this.readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(final int n) {
        char[] original;
        int n2;
        int newLength;
        for (original = new char[n], n2 = this.skip(), newLength = 0; newLength < n && !this.isSpaceChar(n2); original[newLength++] = (char)n2, n2 = this.readByte()) {}
        return (n == newLength) ? original : Arrays.copyOf(original, newLength);
    }
    
    private char[][] nm(final int n, final int n2) {
        final char[][] array = new char[n][];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ns(n2);
        }
        return array;
    }
    
    private int[] na(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ni();
        }
        return array;
    }
    
    private int ni() {
        int n = 0;
        boolean b = false;
        int n2;
        while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10 + (n2 - 48);
            n2 = this.readByte();
        }
        return b ? (-n) : n;
    }
    
    private long nl() {
        long n = 0L;
        boolean b = false;
        int n2;
        while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = this.readByte();
        }
        return b ? (-n) : n;
    }
    
    private void tr(final Object... a) {
        if (this.INPUT.length() > 0) {
            System.out.println(Arrays.deepToString(a));
        }
    }
}
