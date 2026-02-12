import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static FS sc;
    private static PrintWriter pw;
    
    private static void main$3231c38a() {
        final String next = Main.sc.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        if (x == 3 || x <= 1) {
            Main.pw.println(x);
        }
        else if (x == 2) {
            if (next.charAt(1) == 'R') {
                Main.pw.println(2);
            }
            else {
                Main.pw.println(1);
            }
        }
        Main.pw.flush();
    }
    
    static {
        Main.sc = new FS();
        Main.pw = new PrintWriter(System.out);
    }
    
    static final class FS
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        FS() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        final String next() {
            while (!this.st.hasMoreElements()) {
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final Exception ex) {}
            }
            return this.st.nextToken();
        }
        
        private int[] nextArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
