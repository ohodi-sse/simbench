public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Integer[] a = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        int n;
        for (n = 0; Arrays.asList(a).contains(nextInt - n) && Arrays.asList(a).contains(nextInt + n); ++n) {}
        if (Arrays.asList(a).contains(nextInt - n)) {
            System.out.println(nextInt + n);
        }
        else {
            System.out.println(nextInt - n);
        }
    }
}