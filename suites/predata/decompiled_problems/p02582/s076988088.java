import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        for (int n = 1, i = 0; i < n; ++i) {
            final String next = fastScanner.next();
            int n2 = 0;
            int max = 0;
            for (int j = 0; j < next.length(); ++j) {
                if (next.charAt(j) == 'R') {
                    max = Math.max(++n2, max);
                }
                else {
                    n2 = 0;
                }
            }
            System.out.println(max);
        }
    }
    
    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        String next() {
            while (!this.st.hasMoreTokens()) {
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
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

static class FastScanner
{
    BufferedReader br;
    StringTokenizer st;
    
    FastScanner() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.st = new StringTokenizer("");
    }
    
    String next() {
        while (!this.st.hasMoreTokens()) {
            try {
                this.st = new StringTokenizer(this.br.readLine());
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return this.st.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
}
