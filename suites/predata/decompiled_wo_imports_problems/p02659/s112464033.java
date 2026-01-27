public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        scanner.close();
        System.out.println(nextLong * Integer.valueOf(next.replace(".", "")) / 100L);
    }
}