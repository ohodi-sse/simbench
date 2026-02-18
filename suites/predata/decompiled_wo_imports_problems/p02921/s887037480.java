public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastScanner fastScanner;
        final String next = (fastScanner = new Main().new FastScanner()).next();
        final String next2 = fastScanner.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private void solve() throws IOException {
        final FastScanner fastScanner;
        final String next = (fastScanner = new FastScanner()).next();
        final String next2 = fastScanner.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
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