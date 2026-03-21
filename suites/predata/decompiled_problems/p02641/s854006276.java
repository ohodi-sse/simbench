import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.util.Set;
import java.io.PrintWriter;
import java.io.InputStream;





public class Main
{
    private static final String NO = "NO";
    private static final String YES = "YES";
    InputStream is;
    PrintWriter out;
    String INPUT;
    private static final long MOD = 1000000007L;
    private static final long inf = 100000000000L;
    Set<Integer>[] g;
    private byte[] inbuf;
    public int lenbuf;
    public int ptrbuf;
    private boolean[] vis;
    
    public Main() {
        this.INPUT = "";
        this.inbuf = new byte[1024];
        this.lenbuf = 0;
        this.ptrbuf = 0;
    }
    
    void solve() {
        for (int n = 1, i = 0; i < n; ++i) {
            this.solve(i);
        }
    }
    
    void solve(final int n) {
        final int ni = this.ni();
        final int ni2 = this.ni();
        final int[] array = new int[102];
        for (int i = 0; i < ni2; ++i) {
            final int[] array2 = array;
            final int ni3 = this.ni();
            ++array2[ni3];
        }
        int x = ni;
        int n2 = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            if (array[j] == 0) {
                final int abs = Math.abs(j - ni);
                if (abs < n2) {
                    n2 = abs;
                    x = j;
                }
            }
        }
        this.out.println(x);
    }
    
    long power(final long n, long n2) {
        long n3 = 1L;
        long n4 = n;
        while (n2 > 0L) {
            if (n2 % 2L != 0L) {
                n3 = n3 * n4 % 1000000007L;
            }
            n4 = n4 * n4 % 1000000007L;
            n2 /= 2L;
        }
        return n3 % 1000000007L;
    }
    
    private long gcd(long n, long n2) {
        while (n != 0L) {
            final long n3 = n2 % n;
            n2 = n;
            n = n3;
        }
        return n2;
    }
    
    void run() throws Exception {
        this.is = (this.INPUT.isEmpty() ? System.in : new ByteArrayInputStream(this.INPUT.getBytes()));
        this.out = new PrintWriter(System.out);
        final long currentTimeMillis = System.currentTimeMillis();
        this.solve();
        this.out.flush();
        if (!this.INPUT.isEmpty()) {
            tr(System.currentTimeMillis() - currentTimeMillis + "ms");
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
        final char[] original = new char[n];
        int n2 = this.skip();
        int i = 0;
        while (i < n) {
            if (!this.isSpaceChar(n2)) {
                original[i++] = (char)n2;
            }
            n2 = this.readByte();
        }
        return (n == i) ? original : Arrays.copyOf(original, i);
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
    
    private List<Integer> na2(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < n; ++i) {
            list.add(this.ni());
        }
        return list;
    }
    
    private int[][] na(final int n, final int n2) {
        final int[][] array = new int[n][];
        for (int i = 0; i < n; ++i) {
            array[i] = this.na(n2);
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
    
    private long[] nl(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nl();
        }
        return array;
    }
    
    private long[][] nl(final int n, final int n2) {
        final long[][] array = new long[n][];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nl(n2);
        }
        return array;
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
    
    private static void tr(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
    
    public class Pair<K, V>
    {
        private K key;
        private V value;
        
        public K getKey() {
            return this.key;
        }
        
        public V getValue() {
            return this.value;
        }
        
        public Pair(final Main obj, final K key, final V value) {
            Objects.requireNonNull(obj);
            this.key = key;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return String.valueOf(this.key) + "=" + String.valueOf(this.value);
        }
        
        @Override
        public int hashCode() {
            return this.key.hashCode() * 13 + ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof final Pair pair) {
                Label_0052: {
                    if (this.key != null) {
                        if (this.key.equals(pair.key)) {
                            break Label_0052;
                        }
                    }
                    else if (pair.key == null) {
                        break Label_0052;
                    }
                    return false;
                }
                if (this.value != null) {
                    if (this.value.equals(pair.value)) {
                        return true;
                    }
                }
                else if (pair.value == null) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}