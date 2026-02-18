public final class Main
{
    private static void main$3231c38a() {
        final String next = new FastScanner().next();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            final int n = i;
            while (i < 3 && next.charAt(i) == 'R') {
                ++i;
            }
            max = Math.max(max, i - n);
        }
        System.out.println(max);
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