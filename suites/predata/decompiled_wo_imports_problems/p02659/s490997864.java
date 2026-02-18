public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        System.out.println(new BigDecimal(nextLong).multiply(new BigDecimal((long)(nextDouble * 1000.0))).divideToIntegralValue(new BigDecimal("1000")));
    }
}