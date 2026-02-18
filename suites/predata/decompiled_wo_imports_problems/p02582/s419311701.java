public final class Main
{
    private static void main$3231c38a() throws IOException {
        final String next = new Main().new FastScanner().next();
        int max = 0;
        int b = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        System.out.println(max);
    }
    
    private void solve() throws IOException {
        final String next = new FastScanner().next();
        int max = 0;
        int b = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        System.out.println(max);
    }
    
    public final class FastScanner
    {
        private BufferedReader reader;
        private StringTokenizer st;
        
        public FastScanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.st = null;
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public final String next() throws IOException {
            if (this.st == null || !this.st.hasMoreElements()) {
                this.st = new StringTokenizer(this.reader.readLine());
            }
            return this.st.nextToken();
        }
        
        private String nextLine() throws IOException {
            this.st = null;
            return this.reader.readLine();
        }
        
        private int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.next());
        }
        
        private int[] nextIntArr(final int n) throws NumberFormatException, IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] nextLongArr(final int n) throws NumberFormatException, IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private void close() throws IOException {
            this.reader.close();
        }
    }
}