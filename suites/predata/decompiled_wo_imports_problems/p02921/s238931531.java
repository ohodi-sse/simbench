public class Main
{
    public static void main(final String[] array) throws Exception {
        final FastScanner fastScanner = new FastScanner(System.in);
        final char[] charArray = fastScanner.next().toCharArray();
        final char[] charArray2 = fastScanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}class FastScanner
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    public FastScanner(final InputStream in) {
        this.reader = null;
        this.tokenizer = null;
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.tokenizer = null;
    }
    
    public String next() {
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
    
    public String nextLine() {
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
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    public int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public long[] nextLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
}