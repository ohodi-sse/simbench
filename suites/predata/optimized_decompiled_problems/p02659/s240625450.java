import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        final Solver solver = new Solver();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final Solver solver2 = solver;
        solver.A = new BigDecimal(inputReader3.next());
        solver2.B = new BigDecimal(inputReader3.next());
        printWriter2.println(solver2.A.multiply(solver2.B).longValue());
        printWriter.close();
    }
    
    static final class Solver
    {
        BigDecimal A;
        BigDecimal B;
        
        private void solve(final InputReader inputReader, final PrintWriter printWriter) {
            this.A = new BigDecimal(inputReader.next());
            this.B = new BigDecimal(inputReader.next());
            printWriter.println(this.A.multiply(this.B).longValue());
        }
        
        private static void debug(final Object... a) {
            System.err.println(Arrays.deepToString(a));
        }
    }
    
    static final class InputReader
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
        }
        
        final String next() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
