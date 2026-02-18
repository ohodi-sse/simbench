public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Task();
        Task.solve$32964a28(scanner, printWriter);
        printWriter.close();
    }
    
    static final class Task
    {
        public static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println(new BigDecimal("" + scanner.nextDouble()).multiply(new BigDecimal("" + scanner.nextDouble())).toBigInteger());
        }
    }
}