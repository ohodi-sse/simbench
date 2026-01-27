public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        System.out.println(nextLong * Integer.valueOf(next.substring(0, 1)) + nextLong * Integer.parseInt(next.substring(2)) / 100L);
    }
}