public class Main
{
    public static void main(final String[] array) {
        final ConsoleScanner consoleScanner = new ConsoleScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        solve(consoleScanner, printWriter);
        printWriter.flush();
    }
    
    private static void solve(final ConsoleScanner consoleScanner, final PrintWriter printWriter) {
        for (int i = 1; i <= 100; ++i) {
            assert null != System.out.format("%d %d\n", i, solve(i));
        }
        final int nextInt = consoleScanner.nextInt();
        final long currentTimeMillis = System.currentTimeMillis();
        printWriter.println(solve(nextInt));
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
    
    static class ConsoleScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        ConsoleScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}static class ConsoleScanner
{
    BufferedReader br;
    StringTokenizer st;
    
    ConsoleScanner() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.st = new StringTokenizer("");
    }
    
    String next() {
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
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
}