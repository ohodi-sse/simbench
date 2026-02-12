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
        new TaskB();
        final FastReader fastReader2 = fastReader;
        final PrintWriter printWriter2 = printWriter;
        final int int1;
        if ((int1 = Integer.parseInt(fastReader2.next())) < 2) {
            printWriter2.println(1);
        }
        else if (int1 < 4) {
            printWriter2.println(2);
        }
        else if (int1 < 8) {
            printWriter2.println(4);
        }
        else if (int1 < 16) {
            printWriter2.println(8);
        }
        else if (int1 < 32) {
            printWriter2.println(16);
        }
        else if (int1 < 64) {
            printWriter2.println(32);
        }
        else {
            printWriter2.println(64);
        }
        printWriter.close();
    }
    
    static final class TaskB
    {
        private static void solve$3c455bd4(final FastReader fastReader, final PrintWriter printWriter) {
            final int int1;
            if ((int1 = Integer.parseInt(fastReader.next())) < 2) {
                printWriter.println(1);
                return;
            }
            if (int1 < 4) {
                printWriter.println(2);
                return;
            }
            if (int1 < 8) {
                printWriter.println(4);
                return;
            }
            if (int1 < 16) {
                printWriter.println(8);
                return;
            }
            if (int1 < 32) {
                printWriter.println(16);
                return;
            }
            if (int1 < 64) {
                printWriter.println(32);
                return;
            }
            printWriter.println(64);
        }
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
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
    }
}
