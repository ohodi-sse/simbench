import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.math.BigDecimal;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Solver().solve(inputReader, printWriter);
        printWriter.close();
    }
    
    static class Solver
    {
        BigDecimal A;
        BigDecimal B;
        
        void solve(final InputReader inputReader, final PrintWriter printWriter) {
            this.A = new BigDecimal(inputReader.next());
            this.B = new BigDecimal(inputReader.next());
            printWriter.println(this.A.multiply(this.B).longValue());
        }
        
        void debug(final Object... a) {
            System.err.println(Arrays.deepToString(a));
        }
    }
    
    static class InputReader
    {
        BufferedReader reader;
        StringTokenizer tokenizer;
        
        InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
