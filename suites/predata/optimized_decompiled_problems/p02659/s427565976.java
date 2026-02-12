import java.util.function.LongUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class In
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    In() {
        this.reader = new BufferedReader(new InputStreamReader(System.in), 65536);
    }
    
    final String next() {
        try {
            while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
        }
        catch (final IOException ex) {}
        return this.tokenizer.nextToken();
    }
    
    private int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    private long nextLong() {
        return Long.parseLong(this.next());
    }
    
    private char[] nextCharArray() {
        return this.next().toCharArray();
    }
    
    private char[][] nextCharGrid(final int n, final int n2) {
        final char[][] array = new char[n][n2];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next().toCharArray();
        }
        return array;
    }
    
    private int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(this.next());
        }
        return array;
    }
    
    private int[] nextIntArray(final int n, final IntUnaryOperator intUnaryOperator) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = intUnaryOperator.applyAsInt(Integer.parseInt(this.next()));
        }
        return array;
    }
    
    private long[] nextLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(this.next());
        }
        return array;
    }
    
    private long[] nextLongArray(final int n, final LongUnaryOperator longUnaryOperator) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = longUnaryOperator.applyAsLong(Long.parseLong(this.next()));
        }
        return array;
    }
}
import java.util.StringJoiner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static In in;
    private static Out out;
    private static long mod = 1000000007L;
    private static long inf = 2305843009213693951L;
    private static int iinf = 1073741823;
    private static int[] da;
    
    private static void solve() {
        final long long1 = Long.parseLong(Main.in.next());
        final long n = Integer.parseInt(Main.in.next().replace(".", ""));
        final Out out = Main.out;
        final Object[] array = { long1 * n / 100L };
        final Out out2 = out;
        final StringJoiner x = new StringJoiner(" ");
        final int length = array.length;
        for (int i = 0; i <= 0; ++i) {
            x.add(String.valueOf(array[0]));
        }
        out2.out.println(x);
        final boolean autoFlush = out2.autoFlush;
    }
    
    private static void main$3231c38a() {
        new Main();
        final long long1 = Long.parseLong(Main.in.next());
        final long n = Integer.parseInt(Main.in.next().replace(".", ""));
        final Out out = Main.out;
        final Object[] array = { long1 * n / 100L };
        final Out out2 = out;
        final StringJoiner x = new StringJoiner(" ");
        final int length = array.length;
        for (int i = 0; i <= 0; ++i) {
            x.add(String.valueOf(array[0]));
        }
        out2.out.println(x);
        final boolean autoFlush = out2.autoFlush;
        Main.out.out.flush();
    }
    
    static {
        Main.in = new In();
        Main.out = new Out();
    }
}
import java.util.StringJoiner;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

final class Out
{
    PrintWriter out;
    boolean autoFlush;
    
    Out() {
        this.out = new PrintWriter(System.out);
        this.autoFlush = false;
    }
    
    private void println(final Object... array) {
        final StringJoiner x = new StringJoiner(" ");
        final int length = array.length;
        for (int i = 0; i <= 0; ++i) {
            x.add(String.valueOf(array[0]));
        }
        this.out.println(x);
        final boolean autoFlush = this.autoFlush;
    }
    
    private void println(final char[] data) {
        this.out.println(String.valueOf(data));
        final boolean autoFlush = this.autoFlush;
    }
    
    private void println(final int[] array) {
        final StringJoiner x = new StringJoiner(" ");
        for (int length = array.length, i = 0; i < length; ++i) {
            x.add(Integer.toString(array[i]));
        }
        this.out.println(x);
        final boolean autoFlush = this.autoFlush;
    }
    
    private void println(final long[] array) {
        final StringJoiner x = new StringJoiner(" ");
        for (int length = array.length, i = 0; i < length; ++i) {
            x.add(Long.toString(array[i]));
        }
        this.out.println(x);
        final boolean autoFlush = this.autoFlush;
    }
    
    private void flush() {
        this.out.flush();
    }
}
