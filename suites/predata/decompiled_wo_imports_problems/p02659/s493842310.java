public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Task().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class Task
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println(new BigDecimal("" + scanner.nextDouble()).multiply(new BigDecimal("" + scanner.nextDouble())).toBigInteger());
        }
    }
}static class Task
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        printWriter.println(new BigDecimal("" + scanner.nextDouble()).multiply(new BigDecimal("" + scanner.nextDouble())).toBigInteger());
    }
}