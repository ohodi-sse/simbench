public final class Main
{
    private static PrintWriter pw;
    private static MScanner sc;
    
    private static void main() throws Exception {
        final long long1 = Long.parseLong(Main.sc.next());
        final char[] charArray;
        Main.pw.println(long1 * Integer.parseInt("" + (charArray = Main.sc.next().toCharArray())[0]) + long1 * Integer.parseInt("" + charArray[2] + charArray[3]) / 100L);
    }
    
    private static void main$3231c38a() throws Exception {
        Main.pw = new PrintWriter(System.out);
        Main.sc = new MScanner(System.in);
        int n = 1;
        while (n-- > 0) {
            final long long1 = Long.parseLong(Main.sc.next());
            final char[] charArray;
            Main.pw.println(long1 * Integer.parseInt("" + (charArray = Main.sc.next().toCharArray())[0]) + long1 * Integer.parseInt("" + charArray[2] + charArray[3]) / 100L);
        }
        Main.pw.flush();
    }
    
    private static void shuffle(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            final int n = (int)(Math.random() * array.length);
            final int n2 = array[i];
            array[i] = array[n];
            array[n] = n2;
        }
    }
    
    private static void shuffle(final long[] array) {
        for (int i = 0; i < array.length; ++i) {
            final int n = (int)(Math.random() * array.length);
            final long n2 = array[i];
            array[i] = array[n];
            array[n] = n2;
        }
    }
    
    static final class MScanner
    {
        private StringTokenizer st;
        private BufferedReader br;
        
        public MScanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        private MScanner(final String fileName) throws Exception {
            this.br = new BufferedReader(new FileReader(fileName));
        }
        
        public final String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        private int[] intArr(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] longArr(final int n) throws IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private int[] intSortedArr(final int n) throws IOException {
            final int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = Integer.parseInt(this.next());
            }
            final int[] array = a;
            for (int j = 0; j < array.length; ++j) {
                final int n2 = (int)(Math.random() * array.length);
                final int n3 = array[j];
                array[j] = array[n2];
                array[n2] = n3;
            }
            Arrays.sort(a);
            return a;
        }
        
        private long[] longSortedArr(final int n) throws IOException {
            final long[] a = new long[n];
            for (int i = 0; i < n; ++i) {
                a[i] = Long.parseLong(this.next());
            }
            final long[] array = a;
            for (int j = 0; j < array.length; ++j) {
                final int n2 = (int)(Math.random() * array.length);
                final long n3 = array[j];
                array[j] = array[n2];
                array[n2] = n3;
            }
            Arrays.sort(a);
            return a;
        }
        
        private Integer[] IntegerArr(final int n) throws IOException {
            final Integer[] array = new Integer[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private Long[] LongArr(final int n) throws IOException {
            final Long[] array = new Long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        private char nextChar() throws IOException {
            return this.next().charAt(0);
        }
        
        private long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private boolean ready() throws IOException {
            return this.br.ready();
        }
        
        private static void waitForInput() throws InterruptedException {
            Thread.sleep(3000L);
        }
    }
}