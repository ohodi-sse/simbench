public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String replace;
        System.out.println((Long.parseLong((replace = scanner.next().replace(".", "")).substring(0, 1)) * nextLong * 100L + Long.parseLong(replace.substring(1, 2)) * nextLong * 10L + Long.parseLong(replace.substring(2, 3)) * nextLong) / 100L);
    }
}