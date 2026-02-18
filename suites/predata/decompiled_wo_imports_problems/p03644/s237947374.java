public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final int int1 = Integer.parseInt(inputReader2.next());
        int max = 0;
        int x = 1;
        for (int i = 1; i <= int1; ++i) {
            if (TaskB.f(i) > max) {
                x = i;
                max = Math.max(max, TaskB.f(i));
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class TaskB
    {
        static int f(int n) {
            int n2;
            for (n2 = 0; n % 2 == 0; n /= 2, ++n2) {}
            return n2;
        }
        
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            final int int1 = Integer.parseInt(inputReader.next());
            int max = 0;
            int x = 1;
            for (int i = 1; i <= int1; ++i) {
                if (f(i) > max) {
                    x = i;
                    max = Math.max(max, f(i));
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}