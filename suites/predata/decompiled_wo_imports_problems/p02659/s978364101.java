final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        scanner.close();
        final String[] split = next.split("\\.");
        System.out.println(nextLong * Integer.parseInt(split[0] + split[1]) / 100L);
    }
}