import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.math.BigDecimal;

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner(System.in);
        System.out.println(new BigDecimal(fastScanner.nextLong()).multiply(new BigDecimal(fastScanner.next())).setScale(0, 1));
    }
    
    static class FastScanner
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public FastScanner(final InputStream in) {
            this.reader = null;
            this.tokenizer = null;
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.tokenizer = null;
        }
        
        public String next() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken();
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken();
        }
        
        public String nextLine() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken("\n");
                }
            }
            try {
                return this.reader.readLine();
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken("\n");
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
    }
}