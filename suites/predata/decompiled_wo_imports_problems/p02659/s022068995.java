public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String replace = scanner.next().replace(".", "");
        System.out.println((Long.parseLong(replace.substring(0, 1)) * nextLong * 100L + Long.parseLong(replace.substring(1, 2)) * nextLong * 10L + Long.parseLong(replace.substring(2, 3)) * nextLong) / 100L);
    }
}