import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastScanner fastScanner = new FastScanner();
        final int[] array = { 1, 2, 4, 8, 16, 32, 64, 128 };
        final int int1 = Integer.parseInt(fastScanner.nextToken());
        int n = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > int1) {
                n = i;
                break;
            }
        }
        System.out.println(array[n - 1]);
    }
    
    public static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        private FastScanner(final String fileName) {
            try {
                this.br = new BufferedReader(new FileReader(fileName));
            }
            catch (final FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        
        public FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String nextToken() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
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
            this.st = null;
            try {
                return this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        private int nextInt() {
            return Integer.parseInt(this.nextToken());
        }
        
        private long nextLong() {
            return Long.parseLong(this.nextToken());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.nextToken());
        }
    }
}
