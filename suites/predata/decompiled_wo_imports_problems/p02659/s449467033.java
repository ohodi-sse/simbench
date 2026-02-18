public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next;
        System.out.println((scanner = new Scanner(System.in)).nextLong() * (Integer.parseInt((next = scanner.next()).substring(0, 1)) * 100 + Integer.parseInt(next.substring(2, 3)) * 10 + Integer.parseInt(next.substring(3, 4))) / 100L);
        scanner.close();
    }
}