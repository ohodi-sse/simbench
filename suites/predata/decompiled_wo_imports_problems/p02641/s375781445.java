public final class Main
{
    private static final String INPUT_FILE_PATH = "";
    
    private static void solve(final InputReader inputReader, final PrintWriter printWriter) {
        final int int1 = Integer.parseInt(inputReader.nextToken());
        final int int2;
        final int[] array = new int[int2 = Integer.parseInt(inputReader.nextToken())];
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(inputReader.nextToken());
            set.add(array[i]);
        }
        int n;
        for (n = 0; set.contains(int1 - n); ++n) {
            if (!set.contains(int1 + n)) {
                printWriter.println(int1 + n);
                return;
            }
        }
        printWriter.println(int1 - n);
    }
    
    private static void main$3231c38a() throws Exception {
        final InputStream inputStream = "".isEmpty() ? System.in : new FileInputStream(new File(""));
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(inputStream);
        final PrintWriter printWriter = new PrintWriter(out);
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final int int1 = Integer.parseInt(inputReader2.nextToken());
        final int int2;
        final int[] array = new int[int2 = Integer.parseInt(inputReader3.nextToken())];
        final HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(inputReader3.nextToken());
            set.add(array[i]);
        }
        while (true) {
            int n;
            for (n = 0; set.contains(int1 - n); ++n) {
                if (!set.contains(int1 + n)) {
                    printWriter2.println(int1 + n);
                    printWriter.close();
                    return;
                }
            }
            printWriter2.println(int1 - n);
            continue;
        }
    }
    
    private static final class InputReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public InputReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in), 32768);
            this.st = null;
        }
        
        public final String nextToken() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                    continue;
                }
                catch (final IOException cause) {
                    throw new RuntimeException(cause);
                }
                break;
            }
            return this.st.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.nextToken());
        }
        
        private long nextLong() {
            return Long.parseLong(this.nextToken());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.nextToken());
        }
    }
}