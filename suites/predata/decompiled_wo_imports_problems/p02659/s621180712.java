public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final int n = (int)Math.floor(scanner.nextDouble() * 100.0 + 0.5);
        System.out.println(nextLong * (n / 100) + nextLong * (n % 100) / 100L);
    }
}