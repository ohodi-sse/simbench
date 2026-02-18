public final class Main
{
    private static void main$3231c38a() throws Exception {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        out.println(new BigDecimal(Double.valueOf(scanner.nextDouble()).toString()).multiply(new BigDecimal(scanner.nextLong())).longValue());
    }
    
    private static void solve(final InputStream source, final PrintStream printStream) {
        final Scanner scanner = new Scanner(source);
        printStream.println(new BigDecimal(Double.valueOf(scanner.nextDouble()).toString()).multiply(new BigDecimal(scanner.nextLong())).longValue());
    }
}