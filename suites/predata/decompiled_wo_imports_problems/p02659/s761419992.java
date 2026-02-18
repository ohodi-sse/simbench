public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        printWriter2.println(new BigDecimal(inputReader3.next()).multiply(new BigDecimal(inputReader3.next())).longValue());
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            printWriter.println(new BigDecimal(inputReader.next()).multiply(new BigDecimal(inputReader.next())).longValue());
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
    }
}