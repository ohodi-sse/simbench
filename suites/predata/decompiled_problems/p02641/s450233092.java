import java.io.OutputStream;
import java.util.HashSet;
import java.io.PrintWriter;
import java.util.Set;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    Set<Integer> set;
    private PrintWriter out;
    private FastScanner scan;
    
    public Main() {
        this.set = new HashSet<Integer>();
        this.out = new PrintWriter(System.out);
        this.scan = new FastScanner();
    }
    
    public static void main(final String[] array) {
        final Main main = new Main();
        main.solve();
        main.out.close();
    }
    
    public void solve() {
        final int ni = this.ni();
        final int ni2 = this.ni();
        if (ni2 == 0) {
            this.out.println(ni);
            return;
        }
        for (int i = 0; i < ni2; ++i) {
            this.set.add(this.ni());
        }
        int x = 0;
        int abs = 200;
        for (int j = 0; j <= 101; ++j) {
            if (!this.set.contains(j)) {
                if (abs > Math.abs(j - ni)) {
                    abs = Math.abs(j - ni);
                    x = j;
                }
            }
        }
        this.out.println(x);
    }
    
    int ni() {
        return this.scan.nextInt();
    }
    
    int[] ni(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ni();
        }
        return array;
    }
    
    int[][] ni(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.ni();
            }
        }
        return array;
    }
    
    long nl() {
        return this.scan.nextLong();
    }
    
    long[] nl(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nl();
        }
        return array;
    }
    
    long[][] nl(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nl();
            }
        }
        return array;
    }
    
    String ns() {
        return this.scan.next();
    }
    
    String[] ns(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ns();
        }
        return array;
    }
    
    String[][] ns(final int n, final int n2) {
        final String[][] array = new String[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.ns();
            }
        }
        return array;
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
