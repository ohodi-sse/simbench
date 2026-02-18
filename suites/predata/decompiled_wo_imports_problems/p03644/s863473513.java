public final class Main
{
    FastScanner in;
    private PrintWriter out;
    
    public Main() {
        this.in = new FastScanner(System.in);
        this.out = new PrintWriter(System.out);
    }
    
    private static void main$3231c38a() {
        final Main main;
        final int int1 = Integer.parseInt((main = new Main()).in.next());
        int x = 0;
        for (int i = 1; i <= int1; i <<= 1) {
            x = i;
        }
        main.out.println(x);
        main.out.close();
    }
    
    private void calc() {
        final int int1 = Integer.parseInt(this.in.next());
        int x = 0;
        for (int i = 1; i <= int1; i <<= 1) {
            x = i;
        }
        this.out.println(x);
        this.out.close();
    }
    
    final class FastScanner
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        
        public FastScanner(final InputStream stream) {
            Objects.requireNonNull(Main.this);
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        private int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }
        
        private static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private static boolean isEndline(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private int[][] nextIntMap(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                final int[][] array2 = array;
                final int n3 = i;
                final FastScanner in = Main.this.in;
                final int[] array3 = new int[n2];
                for (int j = 0; j < n2; ++j) {
                    array3[j] = Integer.parseInt(in.next());
                }
                array2[n3] = array3;
            }
            return array;
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private long[][] nextLongMap(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                final long[][] array2 = array;
                final int n3 = i;
                final FastScanner in = Main.this.in;
                final long[] array3 = new long[n2];
                for (int j = 0; j < n2; ++j) {
                    array3[j] = Long.parseLong(in.next());
                }
                array2[n3] = array3;
            }
            return array;
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Double.parseDouble(this.next());
            }
            return array;
        }
        
        private double[][] nextDoubleMap(final int n, final int n2) {
            final double[][] array = new double[n][n2];
            for (int i = 0; i < n; ++i) {
                final double[][] array2 = array;
                final int n3 = i;
                final FastScanner in = Main.this.in;
                final double[] array3 = new double[n2];
                for (int j = 0; j < n2; ++j) {
                    array3[j] = Double.parseDouble(in.next());
                }
                array2[n3] = array3;
            }
            return array;
        }
        
        final String next() {
            int codePoint;
            for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
            } while (!isSpaceChar(codePoint = this.read()));
            return sb.toString();
        }
        
        private String[] nextStringArray(final int n) {
            final String[] array = new String[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.next();
            }
            return array;
        }
        
        private String nextLine() {
            int codePoint;
            for (codePoint = this.read(); isEndline(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
            } while (!isEndline(codePoint = this.read()));
            return sb.toString();
        }
    }
}