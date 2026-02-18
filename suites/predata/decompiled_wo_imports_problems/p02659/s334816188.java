public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final BigDecimal bigDecimal;
        (bigDecimal = new BigDecimal(next)).setScale(0);
        final BigDecimal multiplicand;
        (multiplicand = new BigDecimal(next2)).setScale(2, RoundingMode.DOWN);
        System.out.println(bigDecimal.multiply(multiplicand).longValue());
    }
}