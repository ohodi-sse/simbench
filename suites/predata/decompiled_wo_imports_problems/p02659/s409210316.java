public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        System.out.println(nextLong * Integer.parseInt(next.substring(0, 1) + next.substring(2, 4)) / 100L);
    }
}