public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final double nextDouble = scanner.nextDouble();
        if (nextLong == 0L || nextDouble == 0.0) {
            System.out.println("0");
            return;
        }
        final String s = "" + nextDouble;
        long n = 0L;
        long n2 = 0L;
        final long n3 = Integer.parseInt(String.valueOf(s.charAt(0)));
        if (s.length() >= 3) {
            n = Integer.parseInt(String.valueOf(s.charAt(2)));
        }
        if (s.length() >= 4) {
            n2 = Integer.parseInt(String.valueOf(s.charAt(3)));
        }
        final String s2 = "" + (nextLong * n3 * 100L + nextLong * n * 10L + nextLong * n2);
        if (s2.length() <= 2) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < s2.length() - 2; ++i) {
            System.out.print(s2.charAt(i));
        }
        System.out.println("");
    }
}