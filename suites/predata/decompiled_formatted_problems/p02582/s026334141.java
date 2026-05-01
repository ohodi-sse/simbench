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
        new Solution().solve(1, fastReader, printWriter);
        printWriter.close();
    }
    
    static class Solution
    {
        public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
            final String next = fastReader.next();
            int i = 0;
            if (next.contains("RRR")) {
                i = 3;
            }
            else if (next.contains("RR")) {
                i = 2;
            }
            else if (next.contains("R")) {
                i = 1;
            }
            printWriter.print(i);
        }
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in), 32768);
        }
        
        public String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}