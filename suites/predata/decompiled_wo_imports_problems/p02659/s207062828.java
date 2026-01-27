public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final BigDecimal nextBigDecimal = scanner.nextBigDecimal();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        System.out.println(nextBigDecimal.multiply(BigDecimal.valueOf(nextDouble)).longValue());
    }
}