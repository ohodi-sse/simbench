static class InputReader
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    public InputReader(final InputStream in) {
        this.tokenizer = new StringTokenizer("");
        this.reader = new BufferedReader(new InputStreamReader(in));
    }
    
    public String next() {
        while (!this.tokenizer.hasMoreTokens()) {
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return this.tokenizer.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB().solve(inputReader, printWriter);
        printWriter.close();
    }
    
    static void sort(final int[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        Collections.sort((List<Comparable>)list);
        for (int j = 0; j < array.length; ++j) {
            array[j] = (int)list.get(j);
        }
    }
    
    static class TaskB
    {
        public void solve(final InputReader inputReader, final PrintWriter printWriter) {
            final String next = inputReader.next();
            int b = 0;
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == 'R') {
                    ++b;
                }
                else {
                    b = 0;
                }
                max = Math.max(max, b);
            }
            printWriter.print(max);
        }
    }
    
    static class InputReader
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public InputReader(final InputStream in) {
            this.tokenizer = new StringTokenizer("");
            this.reader = new BufferedReader(new InputStreamReader(in));
        }
        
        public String next() {
            while (!this.tokenizer.hasMoreTokens()) {
                try {
                    this.tokenizer = new StringTokenizer(this.reader.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.tokenizer.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
    }
}static class TaskB
{
    public void solve(final InputReader inputReader, final PrintWriter printWriter) {
        final String next = inputReader.next();
        int b = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        printWriter.print(max);
    }
}