import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final MyScanner myScanner = new MyScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(myScanner.next());
        final int int2;
        final int[] array = new int[int2 = Integer.parseInt(myScanner.next())];
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(myScanner.next());
        }
        int j = -1000;
        int n = 0;
        while (j == -1000) {
            for (int n2 = -1; n2 <= 1 && j == -1000; n2 += 2) {
                final int n3 = int1 + n * n2;
                boolean b = true;
                for (int k = 0; k < int2; ++k) {
                    if (array[k] == n3) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    j = n3;
                }
            }
            ++n;
        }
        printWriter.println(j);
        printWriter.flush();
    }
    
    static final class MyScanner
    {
        private BufferedReader br;
        private StringTokenizer tokenizer;
        
        public MyScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public final String next() {
            while (true) {
                if (this.tokenizer != null) {
                    if (this.tokenizer.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.tokenizer = new StringTokenizer(this.br.readLine());
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
