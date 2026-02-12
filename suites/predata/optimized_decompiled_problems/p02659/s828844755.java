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

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final LightScanner lightScanner = new LightScanner(in);
        final LightWriter lightWriter = new LightWriter(out);
        new CMultiplication3();
        final LightScanner lightScanner2 = lightScanner;
        final LightWriter lightWriter2 = lightWriter;
        final LightScanner lightScanner3 = lightScanner2;
        final long long1 = Long.parseLong(lightScanner2.string());
        final double double1 = Double.parseDouble(lightScanner3.string());
        final LightWriter lightWriter3 = lightWriter2;
        final String string = Long.toString(long1 * (int)Math.round(double1 * 100.0) / 100L);
        final LightWriter lightWriter4 = lightWriter3;
        if (!lightWriter3.breaked) {
            lightWriter4.print$3a5feaa1();
        }
        final LightWriter print;
        (print = lightWriter4.print(string)).print(System.lineSeparator());
        print.breaked = true;
        final boolean autoflush = print.autoflush;
        lightWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$749e2011(final LightScanner lightScanner, final LightWriter lightWriter) {
            final String string = Long.toString(Long.parseLong(lightScanner.string()) * (int)Math.round(Double.parseDouble(lightScanner.string()) * 100.0) / 100L);
            if (!lightWriter.breaked) {
                lightWriter.print$3a5feaa1();
            }
            final LightWriter print;
            (print = lightWriter.print(string)).print(System.lineSeparator());
            print.breaked = true;
            final boolean autoflush = print.autoflush;
        }
    }
    
    static final class LightWriter implements AutoCloseable
    {
        private final Writer out;
        boolean autoflush;
        boolean breaked;
        
        private LightWriter(final Writer out) {
            this.autoflush = false;
            this.breaked = true;
            this.out = out;
        }
        
        public LightWriter(final OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
        }
        
        public final LightWriter print$3a5feaa1() {
            try {
                this.out.write(32);
                this.breaked = false;
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
            return this;
        }
        
        public final LightWriter print(final String str) {
            try {
                this.out.write(str, 0, str.length());
                this.breaked = false;
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
            return this;
        }
        
        private LightWriter ans(final String s) {
            if (!this.breaked) {
                this.print$3a5feaa1();
            }
            return this.print(s);
        }
        
        public final LightWriter ans(final long i) {
            return this.ans(Long.toString(i));
        }
        
        public final LightWriter ln() {
            this.print(System.lineSeparator());
            this.breaked = true;
            final boolean autoflush = this.autoflush;
            return this;
        }
        
        @Override
        public final void close() {
            try {
                this.out.close();
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
        }
    }
    
    static final class LightScanner implements AutoCloseable
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public LightScanner(final InputStream in) {
            this.reader = null;
            this.tokenizer = null;
            this.reader = new BufferedReader(new InputStreamReader(in));
        }
        
        public final String string() {
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
        
        private long longs() {
            return Long.parseLong(this.string());
        }
        
        private double doubles() {
            return Double.parseDouble(this.string());
        }
        
        @Override
        public final void close() {
            try {
                this.reader.close();
            }
            catch (final IOException cause) {
                throw new UncheckedIOException(cause);
            }
        }
    }
}
