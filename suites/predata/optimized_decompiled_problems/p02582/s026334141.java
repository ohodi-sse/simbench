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
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Solution();
        final FastReader fastReader2 = fastReader;
        final PrintWriter printWriter2 = printWriter;
        final String next = fastReader2.next();
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
        printWriter2.print(i);
        printWriter.close();
    }
    
    static final class Solution
    {
        private static void solve$3c455bd4(final FastReader fastReader, final PrintWriter printWriter) {
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
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in), 32768);
        }
        
        public final String next() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
