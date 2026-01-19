import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

static class MyScanner
{
    BufferedReader reader;
    StringTokenizer tokenizer;
    
    MyScanner() {
        this.reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    }
    
    String next() {
        try {
            while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
        }
        catch (final IOException ex) {}
        return this.tokenizer.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
}
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final MyScanner myScanner = new MyScanner();
        final String next = myScanner.next();
        final String next2 = myScanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    static class MyScanner
    {
        BufferedReader reader;
        StringTokenizer tokenizer;
        
        MyScanner() {
            this.reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        }
        
        String next() {
            try {
                while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
                    this.tokenizer = new StringTokenizer(this.reader.readLine());
                }
            }
            catch (final IOException ex) {}
            return this.tokenizer.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
