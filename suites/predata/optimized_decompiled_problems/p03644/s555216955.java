import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastScanner fastScanner = new FastScanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        final Question question = new Question();
        final FastScanner fastScanner2 = fastScanner;
        final PrintWriter printWriter2 = printWriter;
        final FastScanner fastScanner3 = fastScanner2;
        final Question question2 = question;
        question.N = Integer.parseInt(fastScanner3.next());
        final PrintWriter printWriter3 = printWriter2;
        Question question3;
        int n;
        for (question3 = question2, n = 0; n < 7 && 1 << n <= question3.N; ++n) {}
        printWriter3.println(1 << n - 1);
        printWriter.close();
        fastScanner.br.close();
    }
    
    static final class Question
    {
        int N;
        
        private int solve() {
            int n;
            for (n = 0; n < 7 && 1 << n <= this.N; ++n) {}
            return 1 << n - 1;
        }
        
        private void main(final FastScanner fastScanner, final PrintWriter printWriter) {
            this.N = Integer.parseInt(fastScanner.next());
            int n;
            for (n = 0; n < 7 && 1 << n <= this.N; ++n) {}
            printWriter.println(1 << n - 1);
        }
        
        private static void p(final Object obj) {
            System.out.print(obj);
        }
        
        private static void pl(final Object x) {
            System.out.println(x);
        }
        
        private static void arp(final int[] a) {
            System.out.println((Object)Arrays.toString(a));
        }
        
        private static void arpp(final int[][] array) {
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array[0].length; ++j) {
                    System.out.print("" + array[i][j]);
                }
                System.out.println((Object)"");
            }
        }
    }
    
    static final class FastScanner
    {
        BufferedReader br;
        private StringTokenizer st;
        
        public FastScanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
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
        
        public final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
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
        
        private void close() throws IOException {
            this.br.close();
        }
    }
}
