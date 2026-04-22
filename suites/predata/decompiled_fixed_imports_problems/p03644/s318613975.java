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
        new TaskB().solve(1, fastReader, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
            final int nextInt = fastReader.nextInt();
            int x = 1;
            int n2 = 0;
            for (int i = 1; i <= nextInt; ++i) {
                final int twoCount = this.getTwoCount(i);
                if (twoCount > n2) {
                    x = i;
                    n2 = twoCount;
                }
            }
            printWriter.println(x);
        }
        
        private int getTwoCount(int n) {
            int n2 = 0;
            while (n % 2 == 0) {
                ++n2;
                n /= 2;
            }
            return n2;
        }
    }
    
    static class FastReader
    {
        BufferedReader reader;
        StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.st = null;
        }
        
        public String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    final String line = this.reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                    continue;
                }
                catch (final Exception ex) {
                    throw new RuntimeException();
                }
                break;
            }
            return this.st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}