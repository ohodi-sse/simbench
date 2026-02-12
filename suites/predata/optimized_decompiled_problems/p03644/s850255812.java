import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static MyScanner in;
    private static PrintWriter out;
    private int N;
    private static int max;
    private static int[] dr;
    private static int[] dc;
    
    private static void main$3231c38a() throws IOException {
        final int[] array = new int[101];
        for (int i = 1; i <= 100; ++i) {
            int n;
            int n2;
            for (n = i, n2 = 0; ((long)n & 0x1L) == 0x0L; n >>= 1, ++n2) {}
            array[i] = n2;
        }
        final int int1 = Integer.parseInt(Main.in.next());
        int n3 = -1;
        int x = 0;
        for (int j = 1; j <= int1; ++j) {
            if (n3 < array[j]) {
                x = j;
                n3 = array[j];
            }
        }
        Main.out.println(x);
        Main.out.flush();
    }
    
    private static boolean isEven(final long n) {
        return (n & 0x1L) == 0x0L;
    }
    
    private static void swap$255f295() {
    }
    
    private static boolean same(final int[] a, final int[] a2) {
        Arrays.sort(a);
        Arrays.sort(a2);
        for (int i = 0; i < a.length; ++i) {
            if (a2[i] != a[i]) {
                return false;
            }
        }
        return true;
    }
    
    static {
        Main.in = new MyScanner();
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
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
