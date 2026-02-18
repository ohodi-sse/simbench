public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long long1 = Long.parseLong((scanner = new Scanner(System.in)).next());
        final double double1 = Double.parseDouble(scanner.next());
        scanner.close();
        System.out.println(BigDecimal.valueOf(long1).multiply(BigDecimal.valueOf(double1)).setScale(0, 1).toString());
    }
}