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
    
    public char nextChar() {
        return this.next().charAt(0);
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
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
        new Task().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class Task
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final int nextInt = inputReader.nextInt();
            int x = 0;
            for (int i = 1; i <= nextInt; ++i) {
                if (i == 1 || i == 2 || i == 4 || i == 8 || i == 16 || i == 32 || i == 64) {
                    x = i;
                }
            }
            printWriter.println(x);
        }
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
        
        public char nextChar() {
            return this.next().charAt(0);
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
    }
}static class Task
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        final int nextInt = inputReader.nextInt();
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            if (i == 1 || i == 2 || i == 4 || i == 8 || i == 16 || i == 32 || i == 64) {
                x = i;
            }
        }
        printWriter.println(x);
    }
}