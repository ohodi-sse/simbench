public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        long n = 0L;
        int n2 = 1;
        for (int i = next.length() - 1; i >= 0; --i) {
            if (next.charAt(i) != '.') {
                n += Character.getNumericValue(next.charAt(i)) * n2;
                n2 *= 10;
            }
        }
        System.out.println(nextLong * n / 100L);
    }
}