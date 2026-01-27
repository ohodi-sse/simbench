public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final double nextDouble = scanner.nextDouble();
        final double nextDouble2 = scanner.nextDouble();
        scanner.close();
        String x = BigDecimal.valueOf(nextDouble).multiply(BigDecimal.valueOf(nextDouble2)).toPlainString();
        final int index = x.indexOf(".");
        if (index >= 0) {
            x = x.substring(0, index);
        }
        System.out.println(x);
    }
}