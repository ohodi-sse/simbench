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

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ARainySeason();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final char[] charArray = inputReader2.next().toCharArray();
        int n = -1;
        int max = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                max = Math.max(max, i - n);
            }
            else {
                n = i;
            }
        }
        printWriter2.println(max);
        printWriter.close();
    }
    
    static final class ARainySeason
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            final char[] charArray = inputReader.next().toCharArray();
            int n = -1;
            int max = 0;
            for (int i = 0; i < charArray.length; ++i) {
                if (charArray[i] == 'R') {
                    max = Math.max(max, i - n);
                }
                else {
                    n = i;
                }
            }
            printWriter.println(max);
        }
    }
    
    static final class InputReader
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
        }
        
        public final String next() {
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
