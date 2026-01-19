import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

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
    
    public int ni() {
        return Integer.parseInt(this.next());
    }
    
    public long nl() {
        return Long.parseLong(this.next());
    }
    
    public void close() throws IOException {
        this.reader.close();
    }
}
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

public class Main implements Closeable
{
    private InputReader in;
    private PrintWriter out;
    
    public Main() {
        this.in = new InputReader(System.in);
        this.out = new PrintWriter(System.out);
    }
    
    public void solve() {
        final int ni = this.in.ni();
        final int ni2 = this.in.ni();
        final boolean[] array = new boolean[201];
        for (int i = 0; i < ni2; ++i) {
            array[this.in.ni()] = true;
        }
        int min = 500;
        int n = 500;
        for (int j = 0; j <= 200; ++j) {
            if (!array[j]) {
                final int abs = Math.abs(ni - j);
                if (abs < n) {
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
    public void close() throws IOException {
        this.in.close();
        this.out.close();
    }
    
    public static void main(final String[] array) throws IOException {
        try (final Main main = new Main()) {
            main.solve();
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
        
        public int ni() {
            return Integer.parseInt(this.next());
        }
        
        public long nl() {
            return Long.parseLong(this.next());
        }
        
        public void close() throws IOException {
            this.reader.close();
        }
    }
}
