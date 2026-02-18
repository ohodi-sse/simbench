final class FastScanner
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
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    private int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(this.next());
        }
        return array;
    }
    
    private long[] nextLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(this.next());
        }
        return array;
    }
}




public final class Main
{
    private static void main$3231c38a() throws Exception {
        final FastScanner fastScanner;
        final char[] charArray = (fastScanner = new FastScanner(System.in)).next().toCharArray();
        final char[] charArray2 = fastScanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}