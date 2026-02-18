public final class Main
{
    private static int MIN;
    private static int MAX;
    private static Reader in;
    private static PrintWriter out;
    
    private static void main$3231c38a() throws IOException {
        Main.out.println((Object)(Long.parseLong(Main.in.next()) * Math.round(Double.parseDouble(Main.in.next()) * 100.0) / 100L));
        Main.in.reader.close();
        Main.out.close();
    }
    
    private static int[] readInt(final int n) throws IOException {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(Main.in.next());
        }
        return array;
    }
    
    private static long[] readLong(final int n) throws IOException {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(Main.in.next());
        }
        return array;
    }
    
    private static String[] readString(final int n) throws IOException {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.in.next();
        }
        return array;
    }
    
    private static void print(final Object obj) {
        Main.out.print(obj);
    }
    
    private static void println(final Object x) {
        Main.out.println(x);
    }
    
    private static void println(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            Main.out.print("" + array[i]);
        }
        Main.out.println((Object)"");
    }
    
    private static void debug(final Object... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            System.out.print(String.valueOf(array[i]));
        }
        System.out.println();
    }
    
    static {
        Main.in = new Reader();
        Main.out = new PrintWriter(System.out);
    }
}









final class Reader
{
    BufferedReader reader;
    private StringTokenizer tokenizer;
    
    Reader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.tokenizer = new StringTokenizer("");
    }
    
    final String next() throws IOException {
        while (!this.tokenizer.hasMoreTokens()) {
            this.tokenizer = new StringTokenizer(this.reader.readLine());
        }
        return this.tokenizer.nextToken();
    }
    
    private int nextInt() throws IOException {
        return Integer.parseInt(this.next());
    }
    
    private double nextDouble() throws IOException {
        return Double.parseDouble(this.next());
    }
    
    private long nextLong() throws IOException {
        return Long.parseLong(this.next());
    }
    
    private String nextLine() throws IOException {
        return this.reader.readLine();
    }
    
    private void close() throws IOException {
        this.reader.close();
    }
}