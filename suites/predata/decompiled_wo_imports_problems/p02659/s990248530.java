public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final BigDecimal nextBigDecimal = scanner.nextBigDecimal();
        final BigDecimal bigDecimal = new BigDecimal(nextLong);
        final BigDecimal bigDecimal2 = new BigDecimal(100);
        System.out.println(bigDecimal.multiply(nextBigDecimal.multiply(bigDecimal2)).divide(bigDecimal2).setScale(0, 1));
    }
}