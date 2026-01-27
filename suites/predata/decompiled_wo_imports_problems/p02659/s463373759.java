public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (long)(100.0 * scanner.nextDouble() + 0.1) / 100L);
    }
}