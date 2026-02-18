public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Task();
        for (int i = 1; i <= 1; ++i) {
            final InputReader inputReader2 = inputReader;
            final PrintWriter printWriter2 = printWriter;
            final char[] charArray = inputReader2.next().toCharArray();
            int n = 0;
            int max = 0;
            for (int j = 0; j < 3; ++j) {
                if (charArray[j] == 'R') {
                    ++n;
                }
                else {
                    max = Math.max(max, n);
                    n = 0;
                }
            }
            printWriter2.println(Math.max(max, n));
        }
        printWriter.close();
    }
    
    private static void sort(final int[] a) {
        final Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            final int nextInt = random.nextInt(a.length);
            final int n = a[i];
            a[i] = a[nextInt];
            a[nextInt] = n;
        }
        Arrays.sort(a);
    }
    
    private static void sort(final long[] a) {
        final Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            final int nextInt = random.nextInt(a.length);
            final long n = a[i];
            a[i] = a[nextInt];
            a[nextInt] = n;
        }
        Arrays.sort(a);
    }
    
    private static void shuffle(final int[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final int n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
    }
    
    private static void shuffle(final long[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final long n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
    }
    
    static final class Task
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            final char[] charArray = inputReader.next().toCharArray();
            int n = 0;
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (charArray[i] == 'R') {
                    ++n;
                }
                else {
                    max = Math.max(max, n);
                    n = 0;
                }
            }
            printWriter.println(Math.max(max, n));
        }
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
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private String nextLine() {
            try {
                return this.reader.readLine();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        private boolean hasNext() {
            String line = null;
            try {
                line = this.reader.readLine();
            }
            catch (final Exception ex) {}
            if (line == null) {
                return false;
            }
            this.tokenizer = new StringTokenizer(line);
            return true;
        }
        
        private int[] nextInta(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] nextLonga(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private int[][] nextIntm(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = Integer.parseInt(this.next());
                }
            }
            return array;
        }
        
        private long[][] nextLongm(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = Long.parseLong(this.next());
                }
            }
            return array;
        }
        
        private BigInteger nextBigInteger() {
            return new BigInteger(this.next());
        }
    }
}