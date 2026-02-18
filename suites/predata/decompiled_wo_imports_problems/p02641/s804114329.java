public final class Main
{
    private static void main$3231c38a() throws Exception {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        if (!set.contains(nextInt)) {
            out.println(nextInt);
            return;
        }
        int n;
        for (n = 1; set.contains(nextInt - n); ++n) {
            if (!set.contains(nextInt + n)) {
                out.println(nextInt + n);
                return;
            }
        }
        out.println(nextInt - n);
    }
    
    private static void solve(final InputStream source, final PrintStream printStream) {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(source)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        if (!set.contains(nextInt)) {
            printStream.println(nextInt);
            return;
        }
        int n;
        for (n = 1; set.contains(nextInt - n); ++n) {
            if (!set.contains(nextInt + n)) {
                printStream.println(nextInt + n);
                return;
            }
        }
        printStream.println(nextInt - n);
    }
}