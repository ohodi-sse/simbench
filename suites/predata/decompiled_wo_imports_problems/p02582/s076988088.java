public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner = new FastScanner();
        for (int i = 0; i <= 0; ++i) {
            final String next = fastScanner.next();
            int n = 0;
            int max = 0;
            for (int j = 0; j < next.length(); ++j) {
                if (next.charAt(j) == 'R') {
                    max = Math.max(++n, max);
                }
                else {
                    n = 0;
                }
            }
            System.out.println(max);
        }
    }
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        final String next() {
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
    }
}