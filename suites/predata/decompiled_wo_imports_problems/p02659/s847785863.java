public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final long long1 = Long.parseLong(scanner.next().replace(".", ""));
        scanner.close();
        System.out.println(nextLong * long1 / 100L);
    }
}