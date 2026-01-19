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
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
}
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

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        int f(int n) {
            int n2;
            for (n2 = 0; n % 2 == 0; n /= 2, ++n2) {}
            return n2;
        }
        
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final int nextInt = inputReader.nextInt();
            int max = 0;
            int x = 1;
            for (int i = 1; i <= nextInt; ++i) {
                if (this.f(i) > max) {
                    x = i;
                    max = Math.max(max, this.f(i));
                }
            }
            printWriter.println(x);
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
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class TaskB
{
    int f(int n) {
        int n2;
        for (n2 = 0; n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
    
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        final int nextInt = inputReader.nextInt();
        int max = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            if (this.f(i) > max) {
                x = i;
                max = Math.max(max, this.f(i));
            }
        }
        printWriter.println(x);
    }
}
