public final class Main
{
    private static long mod = 1000000007L;
    private static long INF = 4611686018427387903L;
    private static int inf = 1073741823;
    
    private static void solve(final InputReader inputReader, final PrintWriter printWriter) {
        final long long1 = Long.parseLong(inputReader.ns());
        final char[] charArray = inputReader.ns().toCharArray();
        long n = 0L;
        for (int i = 0; i < 4; ++i) {
            if (i != 1) {
                n = (n + (charArray[i] - '0')) * 10L;
            }
        }
        printWriter.println(long1 * (n / 10L) / 100L);
    }
    
    private static void main$3231c38a() {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final long long1 = Long.parseLong(inputReader2.ns());
        final char[] charArray = inputReader3.ns().toCharArray();
        long n = 0L;
        for (int i = 0; i < 4; ++i) {
            if (i != 1) {
                n = (n + (charArray[i] - '0')) * 10L;
            }
        }
        printWriter2.println(long1 * (n / 10L) / 100L);
        printWriter.close();
    }
    
    public static final class InputReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public InputReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
            this.st = null;
        }
        
        public final String ns() {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    return this.st.nextToken();
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
            return this.st.nextToken();
        }
        
        private int ni() {
            return Integer.parseInt(this.ns());
        }
        
        private long nl() {
            return Long.parseLong(this.ns());
        }
        
        private double nd() {
            return Double.parseDouble(this.ns());
        }
        
        private char nc() {
            return this.ns().toCharArray()[0];
        }
        
        private int[] ni(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.ns());
            }
            return array;
        }
        
        private long[] nl(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.ns());
            }
            return array;
        }
        
        private double[] nd(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Double.parseDouble(this.ns());
            }
            return array;
        }
    }
}