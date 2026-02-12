import java.io.Reader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int INF;
    private static int MOD;
    private static int[] mh4;
    private static int[] mw4;
    private static int[] mh8;
    private static int[] mw8;
    
    private static void main$3231c38a() throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskX();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        int i;
        int n;
        for (i = Integer.parseInt(inputReader2.nextString()), n = 0; i > 0; i /= 2, ++n) {}
        printWriter2.println((int)Math.pow(2.0, n - 1));
        printWriter.close();
    }
    
    static final class TaskX
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            int i;
            int n;
            for (i = Integer.parseInt(inputReader.nextString()), n = 0; i > 0; i /= 2, ++n) {}
            printWriter.println((int)Math.pow(2.0, n - 1));
        }
    }
    
    static final class InputReader
    {
        private BufferedReader in;
        private StringTokenizer tok;
        
        public final String nextString() {
            while (!this.tok.hasMoreTokens()) {
                try {
                    this.tok = new StringTokenizer(this.in.readLine(), " ");
                    continue;
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                break;
            }
            return this.tok.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.nextString());
        }
        
        private long nextLong() {
            return Long.parseLong(this.nextString());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.nextString());
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.nextString());
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.nextString());
            }
            return array;
        }
        
        public InputReader(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.tok = new StringTokenizer("");
        }
    }
}
