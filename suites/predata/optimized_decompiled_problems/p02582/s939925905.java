import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastScanner fastScanner = new FastScanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next;
        if ((next = fastScanner.next()).contains("RRR")) {
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
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastScanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
            this.st = new StringTokenizer("");
        }
        
        public final String next() throws IOException {
            while (!this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        private long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private String nextLine() throws IOException {
            while (!this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            String s = "";
            while (this.st.hasMoreTokens()) {
                s += this.st.nextToken();
            }
            return s;
        }
        
        private int[] nextIntArr(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] nextLongArr(final int n) throws IOException {
            final long[] array = new long[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private double[] nextDoubleArr(final int n) throws IOException {
            final double[] array = new double[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = Double.parseDouble(this.next());
            }
            return array;
        }
    }
}
