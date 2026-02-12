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
    private static FastReader in;
    
    private static void main$3231c38a() {
        final String[] split = Main.in.nextLine().split("");
        int max = -1;
        int n = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals("R")) {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        System.out.println(Math.max(max, n));
    }
    
    private static void solve(final String s) {
        final String[] split = s.split("");
        int max = -1;
        int n = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals("R")) {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        System.out.println(Math.max(max, n));
    }
    
    static {
        Main.in = new FastReader();
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private String next() {
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
        
        final String nextLine() {
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
