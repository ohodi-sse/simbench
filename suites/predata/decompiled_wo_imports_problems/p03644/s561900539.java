public final class Main
{
    private int n;
    
    private static void main$3231c38a() {
        final Main main = new Main();
        main.n = Integer.parseInt(new FastReader().next());
        Main main2;
        int i;
        for (main2 = main, i = 1; i <= main2.n; i <<= 1) {}
        System.out.println(i / 2);
    }
    
    private void run() {
        this.n = Integer.parseInt(new FastReader().next());
        int i;
        for (i = 1; i <= this.n; i <<= 1) {}
        System.out.println(i / 2);
    }
    
    private void solve() {
        int i;
        for (i = 1; i <= this.n; i <<= 1) {}
        System.out.println(i / 2);
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
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