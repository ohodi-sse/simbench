public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        scanner.close();
        System.out.println(nextLong * (0 + Integer.parseInt(next.substring(0, 1)) * 100 + Integer.parseInt(next.substring(2, 3)) * 10 + Integer.parseInt(next.substring(3, 4)) * 1) / 100L);
    }
}