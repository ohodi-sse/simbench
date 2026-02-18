public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        final FastReader fastReader2 = fastReader;
        final String[] split;
        printWriter.println(Long.parseLong(fastReader2.next()) * (Integer.parseInt(split[0]) * 100 + (((split = fastReader2.next().split("\\.")).length == 1) ? 0L : Integer.parseInt(split[1]))) / 100L);
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$3c455bd4(final FastReader fastReader, final PrintWriter printWriter) {
            final String[] split;
            printWriter.println(Long.parseLong(fastReader.next()) * (Integer.parseInt(split[0]) * 100 + (((split = fastReader.next().split("\\.")).length == 1) ? 0L : Integer.parseInt(split[1]))) / 100L);
        }
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        private String context;
        
        public FastReader(final InputStream in) {
            this(new InputStreamReader(in));
        }
        
        private FastReader(final InputStreamReader in) {
            this.context = null;
            this.br = new BufferedReader(in);
        }
        
        public final String next() {
            final String context = this.context;
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    final String line;
                    if ((line = this.br.readLine()) == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                    continue;
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
                break;
            }
            final String nextToken = this.st.nextToken();
            final String context2 = this.context;
            return nextToken;
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}