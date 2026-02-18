public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final int nextInt = scanner2.nextInt();
        int div = 0;
        int x = 1;
        for (int i = 2; i <= nextInt; ++i) {
            if (div < TaskB.div(i)) {
                div = TaskB.div(i);
                x = i;
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class TaskB
    {
        public static int div(int n) {
            int n2 = 0;
            while (n % 2 == 0) {
                ++n2;
                n /= 2;
            }
            return n2;
        }
        
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final int nextInt = scanner.nextInt();
            int div = 0;
            int x = 1;
            for (int i = 2; i <= nextInt; ++i) {
                if (div < div(i)) {
                    div = div(i);
                    x = i;
                }
            }
            printWriter.println(x);
        }
    }
}