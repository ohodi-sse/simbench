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
}
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.math.BigDecimal;
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
        new CMultiplication3().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class CMultiplication3
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            printWriter.println(new BigDecimal(inputReader.next()).multiply(new BigDecimal(inputReader.next())).longValue());
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
    }
}
import java.math.BigDecimal;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class CMultiplication3
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        printWriter.println(new BigDecimal(inputReader.next()).multiply(new BigDecimal(inputReader.next())).longValue());
    }
}
