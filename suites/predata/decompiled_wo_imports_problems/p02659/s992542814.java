public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        System.out.println((nextLong * (next.charAt(0) - '0') * 100L + nextLong * (next.charAt(2) - '0') * 10L + nextLong * (next.charAt(3) - '0')) / 100L);
    }
}