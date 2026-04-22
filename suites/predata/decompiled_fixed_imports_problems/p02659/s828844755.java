import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.io.BufferedOutputStream;
import java.io.Writer;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final LightScanner lightScanner = new LightScanner(in);
        final LightWriter lightWriter = new LightWriter(out);
        new CMultiplication3().solve(1, lightScanner, lightWriter);
        lightWriter.close();
    }
    
    static class CMultiplication3
    {
        public void solve(final int n, final LightScanner lightScanner, final LightWriter lightWriter) {
            lightWriter.ans(lightScanner.longs() * (int)Math.round(lightScanner.doubles() * 100.0) / 100L).ln();
        }
    }
    
    static class LightWriter implements AutoCloseable
    {
        private final Writer out;
        private boolean autoflush;
        private boolean breaked;
        
        public LightWriter(final Writer out) {
            this.autoflush = false;
            this.breaked = true;
            this.out = out;
        }
        
        public LightWriter(final OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
        }
        
        public LightWriter print(final char c) {
            try {
                this.out.write(c);
                this.breaked = false;
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
            return this;
        }
        
        public LightWriter print(final String str) {
            try {
                this.out.write(str, 0, str.length());
                this.breaked = false;
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
            return this;
        }
        
        public LightWriter ans(final String s) {
            if (!this.breaked) {
                this.print(' ');
            }
            return this.print(s);
        }
        
        public LightWriter ans(final long i) {
            return this.ans(Long.toString(i));
        }
        
        public LightWriter ln() {
            this.print(System.lineSeparator());
            this.breaked = true;
            if (this.autoflush) {
                try {
                    this.out.flush();
                }
                catch (final IOException cause) {
                    throw new UncheckedIOException(cause);
                }
            }
            return this;
        }
        
        @Override
        public void close() {
            try {
                this.out.close();
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
        }
    }
    
    static class LightScanner implements AutoCloseable
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public LightScanner(final InputStream in) {
            this.reader = null;
            this.tokenizer = null;
            this.reader = new BufferedReader(new InputStreamReader(in));
        }
        
        public String string() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken();
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
            return this.tokenizer.nextToken();
        }
        
        public long longs() {
            return Long.parseLong(this.string());
        }
        
        public double doubles() {
            return Double.parseDouble(this.string());
        }
        
        @Override
        public void close() {
            try {
                this.reader.close();
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
        }
    }
}