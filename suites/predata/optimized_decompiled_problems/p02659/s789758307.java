import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final MyScanner myScanner;
        final long long1 = Long.parseLong((myScanner = new MyScanner()).next());
        final String next = myScanner.next();
        System.out.println(long1 * (Integer.parseInt(next.substring(0, 1)) * 100 + Integer.parseInt(next.substring(2, 4))) / 100L);
    }
    
    static final class MyScanner
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        MyScanner() {
            this.reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        }
        
        final String next() {
            try {
                while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                    this.tokenizer = new StringTokenizer(this.reader.readLine());
                }
            }
            catch (final IOException ex) {}
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
