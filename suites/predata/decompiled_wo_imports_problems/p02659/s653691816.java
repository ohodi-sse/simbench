public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(Long.toString(scanner.nextLong())).multiply(new BigDecimal(Double.toString(scanner.nextDouble()))).setScale(0, 1));
        scanner.close();
    }
}