public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new BBreakNumber().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class BBreakNumber
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println((int)Math.pow(2.0, Math.floor(Math.log(scanner.nextInt()) / Math.log(2.0))));
        }
    }
}static class BBreakNumber
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        printWriter.println((int)Math.pow(2.0, Math.floor(Math.log(scanner.nextInt()) / Math.log(2.0))));
    }
}