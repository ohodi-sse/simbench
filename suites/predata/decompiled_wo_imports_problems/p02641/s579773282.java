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
}public class Main
{
    static MyScanner in;
    static PrintWriter out;
    int N;
    static int max;
    static int[] dr;
    static int[] dc;
    static boolean[][] grid;
    static int[] bishopr;
    static int[] bishopc;
    static long H;
    static long W;
    static long cnt;
    
    public static void main(final String[] array) throws IOException {
        final int nextInt = Main.in.nextInt();
        final int nextInt2 = Main.in.nextInt();
        final BitSet set = new BitSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.set(Main.in.nextInt(), true);
        }
        int abs = Integer.MAX_VALUE;
        int x = 0;
        for (int j = 0; j <= 200; ++j) {
            if (!set.get(j) && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        Main.out.println(x);
        Main.out.flush();
    }
    
    static boolean isValid(final int n, final int n2) {
        return n >= 0 && n < Main.H && n2 >= 0 && n2 < Main.W;
    }
    
    private static void dfs(final int n, final int n2) {
        for (int i = 0; i < 4; ++i) {
            final int n3 = Main.bishopr[i] + n;
            final int n4 = Main.bishopc[i] + n2;
            if (isValid(n3, n4) && !Main.grid[n3][n4]) {
                ++Main.cnt;
                Main.grid[n3][n4] = true;
                dfs(n3, n4);
            }
        }
    }
    
    static boolean isEven(final long n) {
        return (n & 0x1L) == 0x0L;
    }
    
    static void swap(int n, int n2) {
        final int n3 = n2;
        n2 = n;
        n = n3;
    }
    
    static {
        Main.in = new MyScanner();
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
        Main.max = 200001;
        Main.dr = new int[] { 1, -1, 0, 0 };
        Main.dc = new int[] { 0, 0, -1, 1 };
        Main.bishopr = new int[] { -1, 1, -1, 1 };
        Main.bishopc = new int[] { 1, 1, -1, -1 };
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