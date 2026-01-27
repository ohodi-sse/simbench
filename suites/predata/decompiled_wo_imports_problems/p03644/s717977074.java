static class FastReader
{
    BufferedReader reader;
    StringTokenizer st;
    
    public FastReader(final InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.st = null;
    }
    
    public String next() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
            try {
                final String line = this.reader.readLine();
                if (line == null) {
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
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB().solve(1, fastReader, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
            printWriter.println(Integer.highestOneBit(fastReader.nextInt()));
        }
    }
    
    static class FastReader
    {
        BufferedReader reader;
        StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.st = null;
        }
        
        public String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    final String line = this.reader.readLine();
                    if (line == null) {
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
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}static class TaskB
{
    public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
        printWriter.println(Integer.highestOneBit(fastReader.nextInt()));
    }
}