public final class Main
{
    private static MyScanner in;
    private static PrintWriter out;
    private int N;
    private static int max;
    private static int[] dr;
    private static int[] dc;
    private static boolean[][] grid;
    private static int[] bishopr;
    private static int[] bishopc;
    private static long H;
    private static long W;
    private static long cnt;
    
    private static void main$3231c38a() throws IOException {
        Main.out.println(new BigDecimal(Main.in.next()).multiply(new BigDecimal(Main.in.next())).longValue());
        Main.out.flush();
    }
    
    private static boolean isValid(final int n, final int n2) {
        return n >= 0 && n < 0L && n2 >= 0 && n2 < 0L;
    }
    
    private static void dfs(final int n, final int n2) {
        for (int i = 0; i < 4; ++i) {
            final int n3 = Main.bishopr[i] + n;
            final int n4 = Main.bishopc[i] + n2;
            if (n3 >= 0 && n3 < 0L && n4 >= 0 && n4 < 0L) {
                throw new NullPointerException();
            }
        }
    }
    
    private static boolean isEven(final long n) {
        return (n & 0x1L) == 0x0L;
    }
    
    private static void swap$255f295() {
    }
    
    static {
        Main.in = new MyScanner();
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
        Main.bishopr = new int[] { -1, 1, -1, 1 };
        Main.bishopc = new int[] { 1, 1, -1, -1 };
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