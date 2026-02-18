public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB();
        final FastReader fastReader2 = fastReader;
        final PrintWriter printWriter2 = printWriter;
        final int int1 = Integer.parseInt(fastReader2.next());
        int x = 1;
        int n = 0;
        for (int i = 1; i <= int1; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            final int n4;
            if ((n4 = n3) > n) {
                x = i;
                n = n4;
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class TaskB
    {
        private static void solve$3c455bd4(final FastReader fastReader, final PrintWriter printWriter) {
            final int int1 = Integer.parseInt(fastReader.next());
            int x = 1;
            int n = 0;
            for (int i = 1; i <= int1; ++i) {
                int n2 = i;
                int n3 = 0;
                while (n2 % 2 == 0) {
                    ++n3;
                    n2 /= 2;
                }
                final int n4;
                if ((n4 = n3) > n) {
                    x = i;
                    n = n4;
                }
            }
            printWriter.println(x);
        }
        
        private static int getTwoCount(int n) {
            int n2 = 0;
            while (n % 2 == 0) {
                ++n2;
                n /= 2;
            }
            return n2;
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