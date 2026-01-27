public class Main
{
    public static void main(final String[] array) throws Exception {
        solve(System.in, System.out);
    }
    
    static void solve(final InputStream source, final PrintStream printStream) {
        final Scanner scanner = new Scanner(source);
        final int nextInt = scanner.nextInt();
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