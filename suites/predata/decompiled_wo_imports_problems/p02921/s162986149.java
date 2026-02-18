public final class Main
{
    private static void solver(final InputReader inputReader, final PrintWriter printWriter) throws Exception {
        final String next = inputReader.next();
        final String next2 = inputReader.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        printWriter.println(x);
    }
    
    private static boolean helper(final long n) {
        return Math.sqrt((double)n) % 1.0 != 0.0;
    }
    
    private static int gcd(int n, int i) {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static void main$3231c38a() throws Exception {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final String next = inputReader2.next();
        final String next2 = inputReader3.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class InputReader
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
        }
        
        public final String next() {
            while (true) {
                if (this.tokenizer != null) {
                    if (this.tokenizer.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.tokenizer = new StringTokenizer(this.reader.readLine());
                    continue;
                }
                catch (final IOException cause) {
                    throw new RuntimeException(cause);
                }
                break;
            }
            return this.tokenizer.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private int[] readIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
    }
}






final class Pair
{
    private int x;
    private int y;
    
    private Pair(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Pair pair = (Pair)o;
        return this.x == pair.x && this.y == pair.y;
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}