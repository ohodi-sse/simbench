public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        scanner.close();
        System.out.println(new BigDecimal(nextLong).multiply(new BigDecimal(next)).toBigInteger());
    }
    
    private static <T> void prtln(final T x) {
        System.out.println(x);
    }
}