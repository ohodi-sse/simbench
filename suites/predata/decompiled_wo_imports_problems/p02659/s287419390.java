public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final double nextDouble = (scanner = new Scanner(System.in)).nextDouble();
        final double nextDouble2 = scanner.nextDouble();
        scanner.close();
        String x;
        final int index;
        if ((index = (x = BigDecimal.valueOf(nextDouble).multiply(BigDecimal.valueOf(nextDouble2)).toPlainString()).indexOf(".")) >= 0) {
            x = x.substring(0, index);
        }
        System.out.println(x);
    }
}