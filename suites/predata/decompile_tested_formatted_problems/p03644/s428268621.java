import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

class ContestReader
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    ContestReader(final InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in));
    }
    
    public String next() {
        while (true) {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
                continue;
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return this.tokenizer.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    public String[] next(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next();
        }
        return array;
    }
    
    public int[] nextInt(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public long[] nextLong(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    public double[] nextDouble(final int n) {
        final double[] array = new double[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextDouble();
        }
        return array;
    }
    
    public char[] nextCharArray() {
        return this.next().toCharArray();
    }
    
    public int[][] nextInt(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nextInt();
            }
        }
        return array;
    }
    
    public long[][] nextLong(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nextLong();
            }
        }
        return array;
    }
    
    public double[][] nextDouble(final int n, final int n2) {
        final double[][] array = new double[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nextDouble();
            }
        }
        return array;
    }
    
    public char[][] nextCharArray(final int n) {
        final char[][] array = new char[n][];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next().toCharArray();
        }
        return array;
    }
}
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static int solve(int i) {
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        return 1 << n;
    }
    
    private static void execute(final ContestReader contestReader, final PrintWriter printWriter) {
        printWriter.println(solve(contestReader.nextInt()));
    }
    
    public static void main(final String[] array) {
        final ContestReader contestReader = new ContestReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        execute(contestReader, printWriter);
        printWriter.flush();
    }
}
