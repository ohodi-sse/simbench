public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastInput fastInput = new FastInput(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ABC175A();
        final FastInput fastInput2 = fastInput;
        final PrintWriter printWriter2 = printWriter;
        final String next = fastInput2.next();
        int b = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        printWriter2.println(max);
        printWriter.close();
    }
    
    static final class ABC175A
    {
        private static void solve$6872edd(final FastInput fastInput, final PrintWriter printWriter) {
            final String next = fastInput.next();
            int b = 0;
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == 'R') {
                    ++b;
                    max = Math.max(max, b);
                }
                else {
                    b = 0;
                }
            }
            printWriter.println(max);
        }
    }
    
    static final class FastInput
    {
        private final BufferedReader in;
        private String[] buff;
        private int index;
        
        public FastInput(final InputStream in) {
            this.index = 0;
            this.in = new BufferedReader(new InputStreamReader(in));
        }
        
        private String nextLine() {
            try {
                return this.in.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        final String next() {
            while (this.buff == null || this.index >= this.buff.length) {
                this.buff = this.nextLine().split(" ");
                this.index = 0;
            }
            return this.buff[this.index++];
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private Double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private BigInteger nextBigInteger() {
            return new BigInteger(this.next());
        }
        
        private BigDecimal nextBigDecimal() {
            return new BigDecimal(this.next());
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
        
        private double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Double.parseDouble(this.next());
            }
            return array;
        }
        
        private int[][] nextInt2DArray(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = Integer.parseInt(this.next());
                }
            }
            return array;
        }
        
        private long[][] nextLong2DArray(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = Long.parseLong(this.next());
                }
            }
            return array;
        }
        
        private char[][] nextChar2DArray(final int n) {
            final char[][] array = new char[n][];
            for (int i = 0; i < n; ++i) {
                array[i] = this.next().toCharArray();
            }
            return array;
        }
    }
}