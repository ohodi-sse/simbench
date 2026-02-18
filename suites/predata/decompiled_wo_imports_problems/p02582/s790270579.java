public final class Main
{
    private static void main$3231c38a() throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Task();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final String next = inputReader2.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
                if (i < next.length() - 1 && next.charAt(i + 1) == 'S') {
                    break;
                }
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class Task
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) throws IOException {
            final String next = inputReader.next();
            int x = 0;
            for (int i = 0; i < next.length(); ++i) {
                if (next.charAt(i) == 'R') {
                    ++x;
                    if (i < next.length() - 1 && next.charAt(i + 1) == 'S') {
                        break;
                    }
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
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private char nextChar() {
            return this.next().charAt(0);
        }
        
        private String nextLine() throws IOException {
            return this.reader.readLine().trim();
        }
    }
}