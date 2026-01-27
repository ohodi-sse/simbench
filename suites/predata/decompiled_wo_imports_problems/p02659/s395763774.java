public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.nextLong()).multiply(new BigDecimal(scanner.next())).toBigInteger());
    }
}