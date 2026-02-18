public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        final Scanner scanner2 = scanner;
        printWriter.println(scanner2.nextLong() * Math.round(scanner2.nextDouble() * 100.0) / 100L);
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println(scanner.nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
        }
    }
}