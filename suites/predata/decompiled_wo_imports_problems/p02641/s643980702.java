public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        int x = 0;
        Arrays.sort(a);
        for (int j = 0; j <= 101; ++j) {
            boolean b = false;
            for (int k = 0; k < a.length; ++k) {
                if (j == a[k]) {
                    b = true;
                    break;
                }
            }
            if (!b && Math.abs(nextInt - x) > Math.abs(nextInt - j)) {
                x = j;
            }
        }
        System.out.println(x);
    }
}