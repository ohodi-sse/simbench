public class Main
{
    public static void main(final String... array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(BigDecimal.valueOf(scanner.nextLong()).multiply(BigDecimal.valueOf(scanner.nextDouble())).toBigInteger());
        }
    }
}