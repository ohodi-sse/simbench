import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main
{
    public static void main(final String[] array) {
        final String next = new FastScanner(System.in).next();
        if (next.equals("RRR")) {
            System.out.println(3);
        }
        else if (next.startsWith("RR") || next.endsWith("RR")) {
            System.out.println(2);
        }
        else if (next.contains("R")) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
    
    private static class FastScanner
    {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;
        
        FastScanner(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in));
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        String nextLine() {
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
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}