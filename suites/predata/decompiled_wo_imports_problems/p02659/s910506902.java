public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        final long longValue = Long.valueOf(next.substring(0, 1));
        final long longValue2 = Long.valueOf(next.substring(2, 3));
        System.out.println(nextLong * longValue + nextLong * longValue2 / 10L + (nextLong * longValue2 % 10L * 10L + nextLong * Long.valueOf(next.substring(3, 4))) / 100L);
    }
}