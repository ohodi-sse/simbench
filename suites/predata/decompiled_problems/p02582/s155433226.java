import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.util.ArrayList;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static PrintWriter out;
    static StringBuilder sb;
    static int mod;
    static long inf;
    static int[] l;
    static int[] r;
    static int n;
    static int c;
    static int t;
    static ArrayList<Integer>[] ad;
    static long[][][] memo;
    static boolean f;
    static boolean[][] vis;
    static int[][] mat;
    static int[][] mat1;
    static int[] ans;
    static int[] a;
    static ArrayList<Integer> rr;
    static ArrayList<Integer> bb;
    static ArrayList<Integer> gg;
    
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        Main.out = new PrintWriter(System.out);
        int x = 0;
        final String nextLine = scanner.nextLine();
        if (nextLine.contains("R")) {
            ++x;
        }
        if (nextLine.contains("RR")) {
            ++x;
        }
        if (nextLine.contains("RRR")) {
            ++x;
        }
        System.out.println(x);
        Main.out.flush();
    }
    
    static {
        Main.mod = 1000000007;
        Main.inf = 10000000000000000L;
    }
    
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public Scanner(final String fileName) throws Exception {
            this.br = new BufferedReader(new FileReader(fileName));
        }
        
        public String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        public String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        public double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        public char nextChar() throws IOException {
            return this.next().charAt(0);
        }
        
        public Long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        public int[] nextArrInt(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextArrLong(final int n) throws IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        public boolean ready() throws IOException {
            return this.br.ready();
        }
        
        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000L);
        }
    }
}
