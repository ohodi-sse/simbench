public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String[] split = scanner.next().split("[.]");
        System.out.println(nextLong * (Integer.valueOf(split[0]) * 100 + Integer.valueOf(split[1])) / 100L);
    }
}