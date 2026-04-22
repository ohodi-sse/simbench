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

public class Main
{
    static int INF;
    static int MOD;
    static int[] mh4;
    static int[] mw4;
    static int[] mh8;
    static int[] mw8;
    
    public static void main(final String[] array) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskX().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static {
        Main.INF = 1073741824;
        Main.MOD = 1000000007;
        Main.mh4 = new int[] { 0, -1, 1, 0 };
        Main.mw4 = new int[] { -1, 0, 0, 1 };
        Main.mh8 = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        Main.mw8 = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
    }
    
    static class TaskX
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            int i;
            int n2;
            for (i = inputReader.nextInt(), n2 = 0; i > 0; i /= 2, ++n2) {}
            printWriter.println((int)Math.pow(2.0, n2 - 1));
        }
    }
    
    static class InputReader
    {
        BufferedReader in;
        StringTokenizer tok;
        
        public String nextString() {
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
        
        public int nextInt() {
            return Integer.parseInt(this.nextString());
        }
        
        public long nextLong() {
            return Long.parseLong(this.nextString());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.nextString());
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        public InputReader(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.tok = new StringTokenizer("");
        }
    }
}