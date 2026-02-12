import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final MyScanner myScanner;
        final String next = (myScanner = new MyScanner()).next();
        final String next2 = myScanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
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
