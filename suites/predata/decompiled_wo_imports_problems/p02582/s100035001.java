public final class Main
{
    private static void main$3231c38a() throws Exception {
        final String next = new FastScanner().next();
        int max = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        System.out.println(Math.max(max, n));
    }
    
    private static void solve() throws Exception {
        final String next = new FastScanner().next();
        int max = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        System.out.println(Math.max(max, n));
    }
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        FastScanner() throws FileNotFoundException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        public final String next() {
            while (!this.st.hasMoreTokens()) {
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        private String nextLine() {
            String line = null;
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}