public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner = new FastScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final FastScanner fastScanner2 = fastScanner;
        final PrintWriter printWriter2 = printWriter;
        final String next = fastScanner2.next();
        int n = 0;
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        printWriter2.println(Math.max(n, max));
        printWriter.close();
    }
    
    private static void solve(final FastScanner fastScanner, final PrintWriter printWriter) {
        final String next = fastScanner.next();
        int n = 0;
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        printWriter.println(Math.max(n, max));
    }
    
    private static void sort(final int[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        Collections.sort((List<Comparable>)list);
        for (int j = 0; j < array.length; ++j) {
            array[j] = (int)list.get(j);
        }
    }
    
    static final class FastScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        final String next() {
            while (!this.st.hasMoreTokens()) {
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}