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
        int int1;
        int x;
        for (int1 = Integer.parseInt(inputReader2.nextString()), x = 1; x << 1 <= int1; x <<= 1) {}
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class TaskB
    {
        private static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            int int1;
            int x;
            for (int1 = Integer.parseInt(inputReader.nextString()), x = 1; x << 1 <= int1; x <<= 1) {}
            printWriter.println(x);
        }
    }
    
    static final class InputReader
    {
        private BufferedReader in;
        private StringTokenizer tok;
        
        public final String nextString() {
            while (!this.tok.hasMoreTokens()) {
                try {
                    this.tok = new StringTokenizer(this.in.readLine(), " ");
                    continue;
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                break;
            }
            return this.tok.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.nextString());
        }
        
        public InputReader(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.tok = new StringTokenizer("");
        }
    }
}