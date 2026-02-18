public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        final InputReader inputReader2 = inputReader;
        printWriter.println(Long.parseLong(inputReader2.next()) * Math.round(Double.parseDouble(inputReader2.next()) * 100.0) / 100L);
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            printWriter.println(Long.parseLong(inputReader.next()) * Math.round(Double.parseDouble(inputReader.next()) * 100.0) / 100L);
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
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}