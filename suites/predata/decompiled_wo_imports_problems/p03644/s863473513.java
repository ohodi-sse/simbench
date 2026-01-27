public class Main
{
    FastScanner in;
    PrintWriter out;
    
    public Main() {
        this.in = new FastScanner(System.in);
        this.out = new PrintWriter(System.out);
    }
    
    public static void main(final String[] array) {
        new Main().calc();
    }
    
    public void calc() {
        final int nextInt = this.in.nextInt();
        int x = 0;
        for (int i = 1; i <= nextInt; i *= 2) {
            x = i;
        }
        this.out.println(x);
        this.out.close();
    }
    
    class FastScanner
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
        
        int read() {
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
        
        boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        boolean isEndline(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        int[][] nextIntMap(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                array[i] = Main.this.in.nextIntArray(n2);
            }
            return array;
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        long[][] nextLongMap(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                array[i] = Main.this.in.nextLongArray(n2);
            }
            return array;
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextDouble();
            }
            return array;
        }
        
        double[][] nextDoubleMap(final int n, final int n2) {
            final double[][] array = new double[n][n2];
            for (int i = 0; i < n; ++i) {
                array[i] = Main.this.in.nextDoubleArray(n2);
            }
            return array;
        }
        
        String next() {
            int codePoint;
            for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.read();
            } while (!this.isSpaceChar(codePoint));
            return sb.toString();
        }
        
        String[] nextStringArray(final int n) {
            final String[] array = new String[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.next();
            }
            return array;
        }
        
        String nextLine() {
            int codePoint;
            for (codePoint = this.read(); this.isEndline(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.read();
            } while (!this.isEndline(codePoint));
            return sb.toString();
        }
    }
}class FastScanner
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
    
    int read() {
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
    
    boolean isSpaceChar(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    boolean isEndline(final int n) {
        return n == 10 || n == 13 || n == -1;
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    int[][] nextIntMap(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.this.in.nextIntArray(n2);
        }
        return array;
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    long[] nextLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    long[][] nextLongMap(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.this.in.nextLongArray(n2);
        }
        return array;
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    double[] nextDoubleArray(final int n) {
        final double[] array = new double[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextDouble();
        }
        return array;
    }
    
    double[][] nextDoubleMap(final int n, final int n2) {
        final double[][] array = new double[n][n2];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.this.in.nextDoubleArray(n2);
        }
        return array;
    }
    
    String next() {
        int codePoint;
        for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isSpaceChar(codePoint));
        return sb.toString();
    }
    
    String[] nextStringArray(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next();
        }
        return array;
    }
    
    String nextLine() {
        int codePoint;
        for (codePoint = this.read(); this.isEndline(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = this.read();
        } while (!this.isEndline(codePoint));
        return sb.toString();
    }
}