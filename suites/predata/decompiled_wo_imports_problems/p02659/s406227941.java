public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(BigDecimal.valueOf(scanner.nextLong()).multiply(BigDecimal.valueOf(scanner.nextDouble())).setScale(0, 1));
    }
}