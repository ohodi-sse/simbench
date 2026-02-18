public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB();
        printWriter.println(Integer.highestOneBit(Integer.parseInt(fastReader.next())));
        printWriter.close();
    }
    
    static final class TaskB
    {
        private static void solve$3c455bd4(final FastReader fastReader, final PrintWriter printWriter) {
            printWriter.println(Integer.highestOneBit(Integer.parseInt(fastReader.next())));
        }
    }
    
    static final class FastReader
    {
        private BufferedReader reader;
        private StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.st = null;
        }
        
        public final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    final String line;
                    if ((line = this.reader.readLine()) == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                    continue;
                }
                catch (final Exception ex) {
                    throw new RuntimeException();
                }
                break;
            }
            return this.st.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}