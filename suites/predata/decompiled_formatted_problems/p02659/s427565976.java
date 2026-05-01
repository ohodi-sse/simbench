import java.util.function.LongUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;





class In
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    In() {
        this.reader = new BufferedReader(new InputStreamReader(System.in), 65536);
    }
    
    String next() {
        try {
            while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
        }
        catch (final IOException ex) {}
        return this.tokenizer.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    char[] nextCharArray() {
        return this.next().toCharArray();
    }
    
    char[][] nextCharGrid(final int n, final int n2) {
        final char[][] array = new char[n][n2];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next().toCharArray();
        }
        return array;
    }
    
    int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    int[] nextIntArray(final int n, final IntUnaryOperator intUnaryOperator) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = intUnaryOperator.applyAsInt(this.nextInt());
        }
        return array;
    }
    
    long[] nextLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    long[] nextLongArray(final int n, final LongUnaryOperator longUnaryOperator) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = longUnaryOperator.applyAsLong(this.nextLong());
        }
        return array;
    }
}




public class Main
{
    static In in;
    static Out out;
    static final long mod = 1000000007L;
    static final long inf = 2305843009213693951L;
    static final int iinf = 1073741823;
    static final int[] da;
    
    void solve() {
        Main.out.println(Main.in.nextLong() * Integer.parseInt(Main.in.next().replace(".", "")) / 100L);
    }
    
    public static void main(final String[] array) {
        new Main().solve();
        Main.out.flush();
    }
    
    static {
        Main.in = new In();
        Main.out = new Out();
        da = new int[] { -1, 0, 1, 0, -1, 1, 1, -1, -1 };
    }
}
import java.util.StringJoiner;
import java.io.OutputStream;
import java.io.PrintWriter;





class Out
{
    private PrintWriter out;
    boolean autoFlush;
    
    Out() {
        this.out = new PrintWriter(System.out);
        this.autoFlush = false;
    }
    
    void println(final Object... array) {
        final StringJoiner x = new StringJoiner(" ");
        for (int length = array.length, i = 0; i < length; ++i) {
            x.add(String.valueOf(array[i]));
        }
        this.out.println(x);
        if (this.autoFlush) {
            this.out.flush();
        }
    }
    
    void println(final char[] data) {
        this.out.println(String.valueOf(data));
        if (this.autoFlush) {
            this.out.flush();
        }
    }
    
    void println(final int[] array) {
        final StringJoiner x = new StringJoiner(" ");
        for (int length = array.length, i = 0; i < length; ++i) {
            x.add(Integer.toString(array[i]));
        }
        this.out.println(x);
        if (this.autoFlush) {
            this.out.flush();
        }
    }
    
    void println(final long[] array) {
        final StringJoiner x = new StringJoiner(" ");
        for (int length = array.length, i = 0; i < length; ++i) {
            x.add(Long.toString(array[i]));
        }
        this.out.println(x);
        if (this.autoFlush) {
            this.out.flush();
        }
    }
    
    void flush() {
        this.out.flush();
    }
}