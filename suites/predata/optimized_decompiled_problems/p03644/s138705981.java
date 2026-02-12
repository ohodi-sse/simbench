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
    private static final int MOD;
    
    private static void main$3231c38a() {
        final int int1;
        int x;
        if ((int1 = Integer.parseInt(new FastReader().next())) >= 64 && int1 <= 100) {
            x = 64;
        }
        else if (int1 >= 32 && int1 <= 63) {
            x = 32;
        }
        else if (int1 >= 16 && int1 <= 31) {
            x = 16;
        }
        else if (int1 >= 8 && int1 <= 15) {
            x = 8;
        }
        else if (int1 >= 4 && int1 <= 7) {
            x = 4;
        }
        else if (int1 >= 2 && int1 <= 3) {
            x = 2;
        }
        else {
            x = 1;
        }
        System.out.println(x);
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
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
    }
}
