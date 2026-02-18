public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskA();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final String next = inputReader2.next();
        final String next2 = inputReader3.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class TaskA
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            final String next = inputReader.next();
            final String next2 = inputReader.next();
            int x = 0;
            for (int i = 0; i < next.length(); ++i) {
                if (next.charAt(i) == next2.charAt(i)) {
                    ++x;
                }
            }
            printWriter.println(x);
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