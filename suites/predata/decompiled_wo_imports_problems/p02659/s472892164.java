public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final BigDecimal nextBigDecimal = scanner.nextBigDecimal();
        final BigDecimal nextBigDecimal2 = scanner.nextBigDecimal();
        scanner.close();
        System.out.println(nextBigDecimal.multiply(nextBigDecimal2).setScale(0, 1));
    }
}