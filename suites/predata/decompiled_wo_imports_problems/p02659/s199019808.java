public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        String x;
        if ((x = new BigDecimal(scanner.nextLong()).multiply(new BigDecimal(Long.parseLong(scanner.next().replace(".", ""))).divide(new BigDecimal("100"))).toString()).contains(".")) {
            x = x.substring(0, x.indexOf("."));
        }
        System.out.println(x);
    }
}