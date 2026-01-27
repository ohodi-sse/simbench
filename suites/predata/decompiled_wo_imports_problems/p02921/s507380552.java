public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ATenki().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class ATenki
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final String nextLine = scanner.nextLine();
            final String nextLine2 = scanner.nextLine();
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                    ++x;
                }
            }
            printWriter.println(x);
        }
    }
}static class ATenki
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        printWriter.println(x);
    }
}