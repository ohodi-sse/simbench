import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Task().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class Task
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) throws IOException {
            final String next = inputReader.next();
            int x = 0;
            for (int i = 0; i < next.length(); ++i) {
                if (next.charAt(i) == 'R') {
                    ++x;
                    if (i < next.length() - 1 && next.charAt(i + 1) == 'S') {
                        break;
                    }
                }
            }
            printWriter.println(x);
        }
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
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public char nextChar() {
            return this.next().charAt(0);
        }
        
        public String nextLine() throws IOException {
            return this.reader.readLine().trim();
        }
    }
}