import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        solve();
    }
    
    private static void solve() throws Exception {
        final String next = new FastScanner().next();
        int max = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        System.out.println(Math.max(max, n));
    }
    
    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        FastScanner() throws FileNotFoundException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        public String next() {
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
        
        public String nextLine() {
            String line = null;
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}
import java.io.IOException;
import java.io.FileNotFoundException;
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
    
    FastScanner() throws FileNotFoundException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.st = new StringTokenizer("");
    }
    
    public String next() {
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
    
    public String nextLine() {
        String line = null;
        try {
            line = this.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
}
