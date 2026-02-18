public class Main
{
    private static void main$3231c38a() {
        final ConsoleScanner consoleScanner = new ConsoleScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final ConsoleScanner consoleScanner2 = consoleScanner;
        final PrintWriter printWriter2 = printWriter;
        final ConsoleScanner consoleScanner3 = consoleScanner2;
        for (int i = 1; i <= 100; ++i) {
            assert null != System.out.format("%d %d\n", i, solve(i));
        }
        final int int1 = Integer.parseInt(consoleScanner3.next());
        final long currentTimeMillis = System.currentTimeMillis();
        printWriter2.println(solve(int1));
        assert null != printWriter2.format("%d elapsed", System.currentTimeMillis() - currentTimeMillis);
        printWriter.flush();
    }
    
    private static void solve(final ConsoleScanner consoleScanner, final PrintWriter printWriter) {
        for (int i = 1; i <= 100; ++i) {
            assert null != System.out.format("%d %d\n", i, solve(i));
        }
        final int int1 = Integer.parseInt(consoleScanner.next());
        final long currentTimeMillis = System.currentTimeMillis();
        printWriter.println(solve(int1));
        assert null != printWriter.format("%d elapsed", System.currentTimeMillis() - currentTimeMillis);
    }
    
    private static int solve(final int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 30; ++i) {
            if (n >> i != 0) {
                min = Math.min(min, n >> i << i);
            }
        }
        return min;
    }
    
    static final class ConsoleScanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        ConsoleScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        final String next() {
            try {
                while (!this.st.hasMoreElements()) {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                return this.st.nextToken();
            }
            catch (final IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}