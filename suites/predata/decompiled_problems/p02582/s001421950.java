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
    static FastScanner fs;
    
    public static void main(final String[] array) {
        final String next = Main.fs.next();
        final int[] array2 = new int[3];
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                array2[i] = 1;
            }
            else {
                array2[i] = 0;
            }
        }
        for (int j = 1; j < 3; ++j) {
            if (array2[j] == 1) {
                final int[] array3 = array2;
                final int n = j;
                array3[n] += array2[j - 1];
            }
        }
        System.out.println(Math.max(array2[0], Math.max(array2[1], array2[2])));
    }
    
    static {
        Main.fs = new FastScanner();
    }
    
    static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        FastScanner() {
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
            String line = "";
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
        
        public long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
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
        String line = "";
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
    
    public long[] readLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
}
