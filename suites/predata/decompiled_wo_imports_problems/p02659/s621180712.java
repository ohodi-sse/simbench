public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final int n = (int)Math.floor(scanner.nextDouble() * 100.0 + 0.5);
        System.out.println(nextLong * (n / 100) + nextLong * (n % 100) / 100L);
    }
}