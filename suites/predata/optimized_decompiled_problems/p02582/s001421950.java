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
    private static FastScanner fs;
    
    private static void main$3231c38a() {
        final String next = Main.fs.next();
        final int[] array = new int[3];
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                array[i] = 1;
            }
            else {
                array[i] = 0;
            }
        }
        for (int j = 1; j < 3; ++j) {
            if (array[j] == 1) {
                final int[] array2 = array;
                final int n = j;
                array2[n] += array[j - 1];
            }
        }
        System.out.println(Math.max(array[0], Math.max(array[1], array[2])));
    }
    
    static {
        Main.fs = new FastScanner();
    }
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        public final String next() {
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
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}
