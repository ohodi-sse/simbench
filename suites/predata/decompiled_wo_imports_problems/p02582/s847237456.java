public final class Main
{
    private static void main$3231c38a() {
        final FastReader fastReader = new FastReader();
        final PrintWriter printWriter = new PrintWriter(System.out);
        new Task();
        for (int i = 1; i <= 1; ++i) {
            final FastReader fastReader2 = fastReader;
            final PrintWriter printWriter2 = printWriter;
            final String next = fastReader2.next();
            printWriter2.println(next.contains("RRR") ? 3 : (next.contains("RR") ? 2 : next.contains("R")));
        }
        printWriter.close();
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
        private static void solve$3c455bd4(final FastReader fastReader, final PrintWriter printWriter) {
            final String next = fastReader.next();
            printWriter.println(next.contains("RRR") ? 3 : (next.contains("RR") ? 2 : next.contains("R")));
        }
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private FastReader(final String pathname) throws FileNotFoundException {
            this.br = new BufferedReader(new FileReader(new File(pathname)));
        }
        
        final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
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
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}