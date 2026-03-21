import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;





public class Main
{
    static MyScanner in;
    static int mod;
    static PrintWriter out;
    static BufferedReader br;
    static StringTokenizer st;
    static int[] dr;
    static int[] dc;
    
    public static void main(final String[] array) {
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
    
    static int rcToxy(final int n, final int n2, final int n3) {
        return n * n3 + n2;
    }
    
    static {
        Main.in = new MyScanner();
        Main.mod = 1000000007;
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        Main.dr = new int[] { 1, -1, 0, 0 };
        Main.dc = new int[] { 0, 0, -1, 1 };
    }
    
    static class Node
    {
        int r;
        int c;
        int prev;
        int change;
        
        Node(final int r, final int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        String nextLine() {
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