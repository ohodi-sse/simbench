public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final long nextLong = scanner.nextLong();
            final String[] split = scanner.next().split("[.]");
            System.out.println(nextLong * (Long.parseLong(split[0]) * 100L + Long.parseLong(split[1])) / 100L);
        }
    }
}