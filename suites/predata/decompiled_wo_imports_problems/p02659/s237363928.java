public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long long1 = Long.parseLong(scanner.next());
        final String next = scanner.next();
        long n = 0L;
        int n2 = 100;
        for (int i = 0; i < 4; ++i) {
            if (!next.substring(i, i + 1).equals(".")) {
                n += n2 * Integer.parseInt(next.substring(i, i + 1));
                n2 /= 10;
            }
        }
        final long n3 = long1 * n;
        System.out.println((n3 - n3 % 100L) / 100L);
    }
}