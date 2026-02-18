public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String plainString = new BigDecimal(String.valueOf((scanner = new Scanner(System.in)).next())).multiply(new BigDecimal(String.valueOf(scanner.next()))).setScale(0, RoundingMode.DOWN).toPlainString();
        scanner.close();
        System.out.println(plainString);
    }
}