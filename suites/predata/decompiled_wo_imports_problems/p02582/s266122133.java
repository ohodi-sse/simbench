public final class Main
{
    private static void main$3231c38a() {
        final String next = new FastScanner(System.in).next();
        int x = 0;
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                if (n > x) {
                    x = n;
                }
                n = 0;
            }
        }
        if (n > x) {
            x = n;
        }
        System.out.println(x);
    }
    
    private static final class FastScanner
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
    }
}