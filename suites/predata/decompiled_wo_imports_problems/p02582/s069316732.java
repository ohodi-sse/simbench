public final class Main
{
    private static void main$3231c38a() {
        final String next = new FastReader().next();
        int b = 0;
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
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
        
        private int[] readArray(final int n, final int n2) {
            final int[] array = new int[n2];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] readLongArray(final int n, final int n2) {
            final long[] array = new long[n2];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
    }
}