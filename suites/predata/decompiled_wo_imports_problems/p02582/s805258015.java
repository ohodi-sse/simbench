public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Task();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final String next = inputReader2.next();
        int x = 0;
        int n = 0;
        char[] charArray;
        for (int length = (charArray = next.toCharArray()).length, i = 0; i < length; ++i) {
            if (charArray[i] == 'S') {
                x = Math.max(x, n);
                n = 0;
            }
            else {
                ++n;
            }
        }
        if (n > 0) {
            x = Math.max(n, x);
        }
        printWriter2.println(x);
        printWriter.flush();
    }
    
    static final class InputReader
    {
        private BufferedReader reader;
        private StringTokenizer tok;
        
        public InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.tok = null;
        }
        
        private InputReader(final String fileName) throws FileNotFoundException {
            this.reader = new BufferedReader(new FileReader(fileName));
            this.tok = null;
        }
        
        private String nextLine() {
            String line;
            try {
                line = this.reader.readLine();
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return line;
        }
        
        public final String next() {
            while (true) {
                if (this.tok != null) {
                    if (this.tok.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.tok = new StringTokenizer(this.nextLine());
                    continue;
                }
                catch (final Exception cause) {
                    throw new RuntimeException(cause);
                }
                break;
            }
            return this.tok.nextToken();
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
    
    static final class Task
    {
        private static void solve(final InputReader inputReader, final PrintWriter printWriter) {
            final String next = inputReader.next();
            int x = 0;
            int n = 0;
            char[] charArray;
            for (int length = (charArray = next.toCharArray()).length, i = 0; i < length; ++i) {
                if (charArray[i] == 'S') {
                    x = Math.max(x, n);
                    n = 0;
                }
                else {
                    ++n;
                }
            }
            if (n > 0) {
                x = Math.max(n, x);
            }
            printWriter.println(x);
        }
    }
}