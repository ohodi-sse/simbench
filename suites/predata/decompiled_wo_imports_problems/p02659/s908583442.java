public final class Main
{
    private static String mul$78238e3a(final String val, final String val2) {
        return new BigDecimal(val).multiply(new BigDecimal(val2)).setScale(0, 1).toString();
    }
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        new Main();
        System.out.println(new BigDecimal(next).multiply(new BigDecimal(next2)).setScale(0, 1).toString());
    }
}