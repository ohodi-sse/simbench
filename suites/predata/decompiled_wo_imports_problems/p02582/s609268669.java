public final class Main
{
    private FastScanner in;
    private PrintWriter out;
    private static int MOD = 1000000007;
    
    private void solve() {
        final String nextStr;
        if ((nextStr = this.in.nextStr()).equals("RSR")) {
            this.out.println("1");
            return;
        }
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextStr.charAt(i) == 'R') {
                ++x;
            }
        }
        this.out.println(x);
    }
    
    private static void main$3231c38a() {
        final Main main;
        (main = new Main()).in = new FastScanner(System.in);
        main.out = new PrintWriter(System.out);
        final Main main2;
        final String nextStr;
        if ((nextStr = (main2 = main).in.nextStr()).equals("RSR")) {
            main2.out.println("1");
        }
        else {
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (nextStr.charAt(i) == 'R') {
                    ++x;
                }
            }
            main2.out.println(x);
        }
        main.out.flush();
        main.in.close();
        main.out.close();
    }
    
    private void m() {
        this.in = new FastScanner(System.in);
        this.out = new PrintWriter(System.out);
        final String nextStr;
        if ((nextStr = this.in.nextStr()).equals("RSR")) {
            this.out.println("1");
        }
        else {
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (nextStr.charAt(i) == 'R') {
                    ++x;
                }
            }
            this.out.println(x);
        }
        this.out.flush();
        this.in.close();
        this.out.close();
    }
    
    static final class FastScanner
    {
        private Reader input;
        
        public FastScanner() {
            this(System.in);
        }
        
        public FastScanner(final InputStream in) {
            this.input = new BufferedReader(new InputStreamReader(in));
        }
        
        public final void close() {
            try {
                this.input.close();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        
        private int nextInt() {
            final long nextLong;
            if ((nextLong = this.nextLong()) < -2147483648L || nextLong > 2147483647L) {
                throw new NumberFormatException();
            }
            return (int)nextLong;
        }
        
        private long nextLong() {
            try {
                int n = 1;
                int n2;
                for (n2 = this.input.read(); (n2 < 48 || 57 < n2) && n2 != 45 && n2 != 43; n2 = this.input.read()) {}
                if (n2 == 45) {
                    n = -1;
                    n2 = this.input.read();
                }
                else if (n2 == 43) {
                    n2 = this.input.read();
                }
                long n3 = n2 - 48;
                int read;
                while ((read = this.input.read()) >= 48 && 57 >= read) {
                    n3 = n3 * 10L + (read - 48);
                }
                return n3 * n;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return -1L;
            }
        }
        
        private double nextDouble() {
            try {
                double n = 1.0;
                int n2;
                for (n2 = this.input.read(); (n2 < 48 || 57 < n2) && n2 != 45 && n2 != 43; n2 = this.input.read()) {}
                if (n2 == 45) {
                    n = -1.0;
                    n2 = this.input.read();
                }
                else if (n2 == 43) {
                    n2 = this.input.read();
                }
                double n3 = n2 - 48;
                int read;
                while ((read = this.input.read()) >= 48 && 57 >= read) {
                    n3 = n3 * 10.0 + (read - 48);
                }
                if (read != 46) {
                    return n * n3;
                }
                double n4 = 1.0;
                for (int n5 = this.input.read(); 48 <= n5 && n5 <= 57; n5 = this.input.read()) {
                    n3 = n3 * 10.0 + (n5 - 48);
                    n4 *= 10.0;
                }
                return n * n3 / n4;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return Double.NaN;
            }
        }
        
        private char nextChar() {
            try {
                int codePoint;
                for (codePoint = this.input.read(); Character.isWhitespace(codePoint); codePoint = this.input.read()) {}
                return (char)codePoint;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return '\0';
            }
        }
        
        public final String nextStr() {
            try {
                final StringBuilder sb = new StringBuilder();
                int n;
                for (n = this.input.read(); Character.isWhitespace(n); n = this.input.read()) {}
                while (n != -1 && !Character.isWhitespace(n)) {
                    sb.append((char)n);
                    n = this.input.read();
                }
                return sb.toString();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return "";
            }
        }
        
        private String nextLine() {
            try {
                final StringBuilder sb = new StringBuilder();
                for (int n = this.input.read(); n != -1 && n != 10; n = this.input.read()) {
                    sb.append((char)n);
                }
                return sb.toString();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return "";
            }
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        private int[] nextIntArrayDec(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt() - 1;
            }
            return array;
        }
        
        private int[] nextIntArray1Index(final int n) {
            final int[] array = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                array[i + 1] = this.nextInt();
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        private long[] nextLongArrayDec(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong() - 1L;
            }
            return array;
        }
        
        private long[] nextLongArray1Index(final int n) {
            final long[] array = new long[n + 1];
            for (int i = 0; i < n; ++i) {
                array[i + 1] = this.nextLong();
            }
            return array;
        }
        
        private double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextDouble();
            }
            return array;
        }
    }
}