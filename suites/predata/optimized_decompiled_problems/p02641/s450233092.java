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
    
    private int readByte() {
        if (this.hasNextByte()) {
            return this.buffer[this.ptr++];
        }
        return -1;
    }
    
    private static boolean isPrintableChar(final int n) {
        return 33 <= n && n <= 126;
    }
    
    private boolean hasNext() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
        return this.hasNextByte();
    }
    
    public final String next() {
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
    
    public final int nextInt() {
        final long nextLong;
        if ((nextLong = this.nextLong()) < -2147483648L || nextLong > 2147483647L) {
            throw new NumberFormatException();
        }
        return (int)nextLong;
    }
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
}
import java.io.OutputStream;
import java.util.HashSet;
import java.io.PrintWriter;
import java.util.Set;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private Set<Integer> set;
    private PrintWriter out;
    private FastScanner scan;
    
    public Main() {
        this.set = new HashSet<Integer>();
        this.out = new PrintWriter(System.out);
        this.scan = new FastScanner();
    }
    
    private static void main$3231c38a() {
        final Main main2;
        final Main main;
        final int nextInt = (main = (main2 = new Main())).scan.nextInt();
        final int nextInt2;
        if ((nextInt2 = main.scan.nextInt()) == 0) {
            main.out.println(nextInt);
        }
        else {
            for (int i = 0; i < nextInt2; ++i) {
                main.set.add(main.scan.nextInt());
            }
            int x = 0;
            int abs = 200;
            for (int j = 0; j <= 101; ++j) {
                if (!main.set.contains(j) && abs > Math.abs(j - nextInt)) {
                    abs = Math.abs(j - nextInt);
                    x = j;
                }
            }
            main.out.println(x);
        }
        main2.out.close();
    }
    
    private void solve() {
        final int nextInt = this.scan.nextInt();
        final int nextInt2;
        if ((nextInt2 = this.scan.nextInt()) == 0) {
            this.out.println(nextInt);
            return;
        }
        for (int i = 0; i < nextInt2; ++i) {
            this.set.add(this.scan.nextInt());
        }
        int x = 0;
        int abs = 200;
        for (int j = 0; j <= 101; ++j) {
            if (!this.set.contains(j) && abs > Math.abs(j - nextInt)) {
                abs = Math.abs(j - nextInt);
                x = j;
            }
        }
        this.out.println(x);
    }
    
    private int ni() {
        return this.scan.nextInt();
    }
    
    private int[] ni(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.scan.nextInt();
        }
        return array;
    }
    
    private int[][] ni(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.scan.nextInt();
            }
        }
        return array;
    }
    
    private long nl() {
        return this.scan.nextLong();
    }
    
    private long[] nl(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.scan.nextLong();
        }
        return array;
    }
    
    private long[][] nl(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.scan.nextLong();
            }
        }
        return array;
    }
    
    private String ns() {
        return this.scan.next();
    }
    
    private String[] ns(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.scan.next();
        }
        return array;
    }
    
    private String[][] ns(final int n, final int n2) {
        final String[][] array = new String[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.scan.next();
            }
        }
        return array;
    }
}
