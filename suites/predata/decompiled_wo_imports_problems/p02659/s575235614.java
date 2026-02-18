final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.nextBigDecimal().multiply(new BigDecimal((int)(scanner.nextDouble() * 100.0 + 0.5))).divide(BigDecimal.valueOf(100L)).setScale(0, 1));
    }
}