public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class CMultiplication3
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println(scanner.nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
        }
    }
}static class CMultiplication3
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        printWriter.println(scanner.nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
    }
}