public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new A();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final String next = scanner2.next();
        final String next2 = scanner3.next();
        int x = 0;
        if (next.charAt(0) == next2.charAt(0)) {
            ++x;
        }
        if (next.charAt(1) == next2.charAt(1)) {
            ++x;
        }
        if (next.charAt(2) == next2.charAt(2)) {
            ++x;
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class A
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final String next = scanner.next();
            final String next2 = scanner.next();
            int x = 0;
            if (next.charAt(0) == next2.charAt(0)) {
                ++x;
            }
            if (next.charAt(1) == next2.charAt(1)) {
                ++x;
            }
            if (next.charAt(2) == next2.charAt(2)) {
                ++x;
            }
            printWriter.println(x);
        }
    }
}