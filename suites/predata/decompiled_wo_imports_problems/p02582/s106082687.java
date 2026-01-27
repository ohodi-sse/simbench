static class InputReader
{
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    
    public InputReader(final InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in), 32768);
        this.tokenizer = null;
    }
    
    public String next() {
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
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        printWriter.println(TaskA.solve(0, inputReader));
        printWriter.close();
    }
    
    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        
        public InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
        }
        
        public String next() {
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
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}class TaskA
{
    public static int solve(final int n, final Main.InputReader inputReader) {
        int n2 = 0;
        final String next = inputReader.next();
        if (next.contains("RRR")) {
            n2 = 3;
        }
        else if (next.contains("RR")) {
            n2 = 2;
        }
        else if (next.contains("R")) {
            n2 = 1;
        }
        return n2;
    }
}