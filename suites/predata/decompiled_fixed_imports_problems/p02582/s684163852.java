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
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ARainySeason().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class ARainySeason
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final char[] charArray = inputReader.next().toCharArray();
            int n2 = -1;
            int max = 0;
            for (int i = 0; i < charArray.length; ++i) {
                if (charArray[i] == 'R') {
                    max = Math.max(max, i - n2);
                }
                else {
                    n2 = i;
                }
            }
            printWriter.println(max);
        }
    }
    
    static class InputReader
    {
        public final BufferedReader reader;
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
    }
}