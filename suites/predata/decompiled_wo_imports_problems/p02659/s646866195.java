public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        System.out.println(nextLong * (((0L + (next.charAt(0) - '0')) * 10L + (next.charAt(2) - '0')) * 10L + (next.charAt(3) - '0')) / 100L);
    }
}