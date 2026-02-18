public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final BigDecimal value;
        (value = BigDecimal.valueOf(scanner.nextDouble())).multiply(BigDecimal.valueOf(nextLong));
        System.out.println(value.multiply(BigDecimal.valueOf(nextLong)).longValue());
    }
}