import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static MyScanner in;
    private static int mod;
    private static PrintWriter out;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] dr;
    private static int[] dc;
    
    private static void main$3231c38a() {
        final String next = Main.in.next();
        int max = 0;
        final int length = next.length();
        int a = 0;
        for (int i = 0; i < length; ++i) {
            if (next.charAt(i) == 'R') {
                for (int index = i; index < next.length() && next.charAt(index) == 'R'; ++index) {
                    ++a;
                }
                max = Math.max(a, max);
                a = 0;
            }
        }
        Main.out.println(max);
        Main.out.flush();
    }
    
    private static int rcToxy(final int n, final int n2, final int n3) {
        return n * n3 + n2;
    }
    
    static {
        Main.in = new MyScanner();
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
        new BufferedReader(new InputStreamReader(System.in));
    }
    
    static final class Node
    {
        private int r;
        private int c;
        private int prev;
        private int change;
        
        private Node(final int r, final int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static final class MyScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public MyScanner() {
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
