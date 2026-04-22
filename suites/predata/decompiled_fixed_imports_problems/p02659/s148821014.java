import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3().solve(1, fastReader, printWriter);
        printWriter.close();
    }
    
    static class CMultiplication3
    {
        public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
            final long nextLong = fastReader.nextLong();
            final String[] split = fastReader.next().split("\\.");
            printWriter.println(nextLong * (Integer.parseInt(split[0]) * 100 + ((split.length == 1) ? 0L : Integer.parseInt(split[1]))) / 100L);
        }
    }
    
    static class FastReader
    {
        public BufferedReader br;
        public StringTokenizer st;
        String context;
        
        public FastReader(final InputStream in) {
            this(new InputStreamReader(in));
        }
        
        public FastReader(final InputStreamReader in) {
            this.context = null;
            this.br = new BufferedReader(in);
        }
        
        public String next() {
            if (this.context != null) {
                System.err.print("[" + this.context + "] Wait for input ...");
            }
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    final String line = this.br.readLine();
                    if (line == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                    continue;
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
                break;
            }
            final String nextToken = this.st.nextToken();
            if (this.context != null) {
                System.err.println("[" + this.context + "] ... received : " + nextToken);
            }
            return nextToken;
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}