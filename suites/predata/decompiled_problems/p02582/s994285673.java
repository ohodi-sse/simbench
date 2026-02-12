import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static final FS sc;
    static final PrintWriter pw;
    
    public static void main(final String[] array) {
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
        sc = new FS();
        pw = new PrintWriter(System.out);
    }
    
    static class FS
    {
        BufferedReader br;
        StringTokenizer st;
        
        FS() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        String next() {
            while (!this.st.hasMoreElements()) {
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final Exception ex) {}
            }
            return this.st.nextToken();
        }
        
        int[] nextArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
