final class ContestReader
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    ContestReader(final InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in));
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
            catch (final Exception cause) {
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
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    private String[] next(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next();
        }
        return array;
    }
    
    private int[] nextInt(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(this.next());
        }
        return array;
    }
    
    private long[] nextLong(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(this.next());
        }
        return array;
    }
    
    private double[] nextDouble(final int n) {
        final double[] array = new double[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Double.parseDouble(this.next());
        }
        return array;
    }
    
    private char[] nextCharArray() {
        return this.next().toCharArray();
    }
    
    private int[][] nextInt(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Integer.parseInt(this.next());
            }
        }
        return array;
    }
    
    private long[][] nextLong(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Long.parseLong(this.next());
            }
        }
        return array;
    }
    
    private double[][] nextDouble(final int n, final int n2) {
        final double[][] array = new double[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = Double.parseDouble(this.next());
            }
        }
        return array;
    }
    
    private char[][] nextCharArray(final int n) {
        final char[][] array = new char[n][];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next().toCharArray();
        }
        return array;
    }
}







public final class Main
{
    private static int solve(int i) {
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        return 1 << n;
    }
    
    private static void execute(final ContestReader contestReader, final PrintWriter printWriter) {
        int i;
        int n;
        for (i = Integer.parseInt(contestReader.next()), n = 0; i > 1; i /= 2, ++n) {}
        printWriter.println(1 << n);
    }
    
    private static void main$3231c38a() {
        final ContestReader contestReader = new ContestReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final ContestReader contestReader2 = contestReader;
        final PrintWriter printWriter2 = printWriter;
        int i = Integer.parseInt(contestReader2.next());
        final PrintWriter printWriter3 = printWriter2;
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        printWriter3.println(1 << n);
        printWriter.flush();
    }
}