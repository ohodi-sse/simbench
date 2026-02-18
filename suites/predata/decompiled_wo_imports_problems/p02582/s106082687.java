public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        int x = 0;
        final String next;
        if ((next = inputReader.next()).contains("RRR")) {
            x = 3;
        }
        else if (next.contains("RR")) {
            x = 2;
        }
        else if (next.contains("R")) {
            x = 1;
        }
        printWriter.println(x);
        printWriter.close();
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
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}




final class TaskA
{
    private static int solve$6d3ee072(final Main.InputReader inputReader) {
        int n = 0;
        final String next;
        if ((next = inputReader.next()).contains("RRR")) {
            n = 3;
        }
        else if (next.contains("RR")) {
            n = 2;
        }
        else if (next.contains("R")) {
            n = 1;
        }
        return n;
    }
}