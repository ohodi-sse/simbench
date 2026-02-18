public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new abc139_a();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final String[] split = scanner2.next().split("");
        final String[] split2 = scanner3.next().split("");
        int x = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].compareTo(split2[i]) == 0) {
                ++x;
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class abc139_a
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final String[] split = scanner.next().split("");
            final String[] split2 = scanner.next().split("");
            int x = 0;
            for (int i = 0; i < split.length; ++i) {
                if (split[i].compareTo(split2[i]) == 0) {
                    ++x;
                }
            }
            printWriter.println(x);
        }
    }
}