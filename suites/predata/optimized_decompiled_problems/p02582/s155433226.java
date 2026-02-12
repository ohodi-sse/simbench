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

public final class Main
{
    private static PrintWriter out;
    private static StringBuilder sb;
    private static int mod;
    private static long inf;
    private static int[] l;
    private static int[] r;
    private static int n;
    private static int c;
    private static int t;
    private static ArrayList<Integer>[] ad;
    private static long[][][] memo;
    private static boolean f;
    private static boolean[][] vis;
    private static int[][] mat;
    private static int[][] mat1;
    private static int[] ans;
    private static int[] a;
    private static ArrayList<Integer> rr;
    private static ArrayList<Integer> bb;
    private static ArrayList<Integer> gg;
    
    private static void main$3231c38a() throws Exception {
        final Scanner scanner = new Scanner(System.in);
        Main.out = new PrintWriter(System.out);
        int x = 0;
        final String line;
        if ((line = scanner.br.readLine()).contains("R")) {
            ++x;
        }
        if (line.contains("RR")) {
            ++x;
        }
        if (line.contains("RRR")) {
            ++x;
        }
        System.out.println(x);
        Main.out.flush();
    }
    
    static final class Scanner
    {
        private StringTokenizer st;
        BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        private Scanner(final String fileName) throws Exception {
            this.br = new BufferedReader(new FileReader(fileName));
        }
        
        private String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        private String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        private char nextChar() throws IOException {
            return this.next().charAt(0);
        }
        
        private Long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private int[] nextArrInt(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] nextArrLong(final int n) throws IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private boolean ready() throws IOException {
            return this.br.ready();
        }
        
        private static void waitForInput() throws InterruptedException {
            Thread.sleep(3000L);
        }
    }
}
