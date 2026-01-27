public class Main
{
    public static void main(final String[] array) throws Exception {
        solve(System.in, System.out);
    }
    
    static void solve(final InputStream source, final PrintStream printStream) {
        final Scanner scanner = new Scanner(source);
        printStream.println(new BigDecimal(Double.valueOf(scanner.nextDouble()).toString()).multiply(new BigDecimal(scanner.nextLong())).longValue());
    }
}