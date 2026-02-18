public final class Main
{
    private static void main$3231c38a() {
        final FastIO fastIO = new FastIO();
        int x = 0;
        final String read = fastIO.read();
        final String read2 = fastIO.read();
        for (int i = 0; i < read.length(); ++i) {
            if (read.charAt(i) == read2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static final class FastIO
    {
        private StringTokenizer stringTokenizer;
        private BufferedReader bufferedReader;
        
        public FastIO() {
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            this.stringTokenizer = null;
        }
        
        public final String read() {
            if (this.stringTokenizer != null) {
                if (this.stringTokenizer.hasMoreTokens()) {
                    return this.stringTokenizer.nextToken();
                }
            }
            try {
                this.stringTokenizer = new StringTokenizer(this.bufferedReader.readLine());
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.stringTokenizer.nextToken();
        }
        
        private int readInt() {
            return Integer.parseInt(this.read());
        }
        
        private long readLong() {
            return Long.parseLong(this.read());
        }
    }
}