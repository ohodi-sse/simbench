public final class Main
{
    private static void main$3231c38a() throws Exception {
        final FastScanner fastScanner = new FastScanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(new BigDecimal(fastScanner.next()).multiply(new BigDecimal(fastScanner.next())).longValue());
        printWriter.flush();
    }
    
    static final class FastScanner
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public FastScanner(final InputStream in) {
            this.reader = null;
            this.tokenizer = null;
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.tokenizer = null;
        }
        
        public final String next() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken();
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken();
        }
        
        private String nextLine() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken("\n");
                }
            }
            try {
                return this.reader.readLine();
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken("\n");
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}