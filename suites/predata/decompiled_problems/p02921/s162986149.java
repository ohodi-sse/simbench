import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static void solver(final InputReader inputReader, final PrintWriter printWriter) throws Exception {
        final String next = inputReader.next();
        final String next2 = inputReader.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        printWriter.println(x);
    }
    
    private static boolean helper(final long n) {
        return Math.sqrt((double)n) % 1.0 != 0.0;
    }
    
    private static int gcd(final int n, final int n2) {
        if (n2 == 0) {
            return n;
        }
        return gcd(n2, n % n2);
    }
    
    public static void main(final String[] array) throws Exception {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        solver(inputReader, printWriter);
        printWriter.close();
    }
    
    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        
        public InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
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
                catch (final IOException cause) {
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
        
        public int[] readIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
    }
}
