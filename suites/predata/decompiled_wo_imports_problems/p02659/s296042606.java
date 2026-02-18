public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.nextLong()).multiply(new BigDecimal(Long.valueOf(scanner.next().replace(".", "")))).divide(new BigDecimal(100)).longValue());
    }
}