import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Closeable;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main implements Closeable
{
    private InputReader in;
    private PrintWriter out;
    
    public Main() {
        this.in = new InputReader(System.in);
        this.out = new PrintWriter(System.out);
    }
    
    private void solve() {
        final int int1 = Integer.parseInt(this.in.next());
        final int int2 = Integer.parseInt(this.in.next());
        final boolean[] array = new boolean[201];
        for (int i = 0; i < int2; ++i) {
            array[Integer.parseInt(this.in.next())] = true;
        }
        int min = 500;
        int n = 500;
        for (int j = 0; j <= 200; ++j) {
            if (!array[j]) {
                final int abs;
                if ((abs = Math.abs(int1 - j)) < n) {
                    min = j;
                    n = abs;
                }
                else if (abs == n) {
                    min = Math.min(min, j);
                }
            }
        }
        this.out.println(min);
    }
    
    @Override
    public final void close() throws IOException {
        this.in.reader.close();
        this.out.close();
    }
    
    private static void main$3231c38a() throws IOException {
        try (final Main main = new Main()) {
            final Main main2;
            final int int1 = Integer.parseInt((main2 = main).in.next());
            final int int2 = Integer.parseInt(main2.in.next());
            final boolean[] array = new boolean[201];
            for (int i = 0; i < int2; ++i) {
                array[Integer.parseInt(main2.in.next())] = true;
            }
            int min = 500;
            int n = 500;
            for (int j = 0; j <= 200; ++j) {
                if (!array[j]) {
                    final int abs;
                    if ((abs = Math.abs(int1 - j)) < n) {
                        min = j;
                        n = abs;
                    }
                    else if (abs == n) {
                        min = Math.min(min, j);
                    }
                }
            }
            main2.out.println(min);
        }
    }
    
    static final class InputReader
    {
        public BufferedReader reader;
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
        
        private int ni() {
            return Integer.parseInt(this.next());
        }
        
        private long nl() {
            return Long.parseLong(this.next());
        }
        
        private void close() throws IOException {
            this.reader.close();
        }
    }
}
