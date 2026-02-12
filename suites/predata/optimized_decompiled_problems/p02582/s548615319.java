import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next;
        if ((next = scanner.next()).contains("RRR")) {
            printWriter.println(3);
        }
        else if (next.contains("RR")) {
            printWriter.println(2);
        }
        else if (next.contains("R")) {
            printWriter.println(1);
        }
        else {
            printWriter.println(0);
        }
        printWriter.close();
    }
    
    static final class Scanner
    {
        private StringTokenizer st;
        private BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public final String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        private double nextDouble() throws IOException {
            final String next = this.next();
            StringBuilder sb = new StringBuilder("0");
            double n = 0.0;
            double n2 = 1.0;
            boolean b = false;
            boolean b2 = false;
            int i = 0;
            if (next.charAt(0) == '-') {
                b2 = true;
                ++i;
            }
            while (i < next.length()) {
                if (next.charAt(i) == '.') {
                    n = (double)Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    b = true;
                }
                else {
                    sb.append(next.charAt(i));
                    if (b) {
                        n2 *= 10.0;
                    }
                }
                ++i;
            }
            return (n + Long.parseLong(sb.toString()) / n2) * (b2 ? -1 : 1);
        }
        
        private boolean ready() throws IOException {
            return this.br.ready();
        }
    }
}
