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
        final InputReader inputReader3 = inputReader2;
        final int int1 = Integer.parseInt(inputReader2.nextToken());
        final int int2;
        final int[] array = new int[int2 = Integer.parseInt(inputReader3.nextToken())];
        final boolean[] array2 = new boolean[101];
        for (int i = 0; i < int2; ++i) {
            array2[Integer.parseInt(inputReader3.nextToken())] = true;
        }
        int x = 101;
        int x2 = 0;
        for (int j = int1; j >= 0; --j) {
            if (!array2[j]) {
                x2 = j;
                break;
            }
        }
        for (int k = int1 + 1; k <= 100; ++k) {
            if (!array2[k]) {
                x = k;
                break;
            }
        }
        if (x - int1 < int1 - x2) {
            printWriter2.println(x);
        }
        else {
            printWriter2.println(x2);
        }
        printWriter.close();
    }
    
    static final class Task
    {
        private static void solve(final InputReader inputReader, final PrintWriter printWriter) {
            final int int1 = Integer.parseInt(inputReader.nextToken());
            final int int2;
            final int[] array = new int[int2 = Integer.parseInt(inputReader.nextToken())];
            final boolean[] array2 = new boolean[101];
            for (int i = 0; i < int2; ++i) {
                array2[Integer.parseInt(inputReader.nextToken())] = true;
            }
            int x = 101;
            int x2 = 0;
            for (int j = int1; j >= 0; --j) {
                if (!array2[j]) {
                    x2 = j;
                    break;
                }
            }
            for (int k = int1 + 1; k <= 100; ++k) {
                if (!array2[k]) {
                    x = k;
                    break;
                }
            }
            if (x - int1 < int1 - x2) {
                printWriter.println(x);
                return;
            }
            printWriter.println(x2);
        }
    }
    
    static final class InputReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public InputReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public final String nextToken() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        return this.st.nextToken();
                    }
                }
                String line;
                try {
                    line = this.br.readLine();
                }
                catch (final IOException cause) {
                    throw new RuntimeException(cause);
                }
                if (line == null) {
                    return null;
                }
                this.st = new StringTokenizer(line);
            }
        }
        
        private int nextInt() {
            return Integer.parseInt(this.nextToken());
        }
        
        private long nextLong() {
            return Long.parseLong(this.nextToken());
        }
    }
}