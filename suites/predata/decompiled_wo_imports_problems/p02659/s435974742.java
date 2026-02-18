public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next;
        System.out.println((nextLong * (((next = scanner.next()).charAt(0) - '0') * 100) + nextLong * ((next.charAt(2) - '0') * 10) + nextLong * (next.charAt(3) - '0')) / 100L);
    }
}