public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
        final int[] array2 = new int[100 - nextInt2 + 2];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = 0;
        array2[0] = 0;
        array2[100 - nextInt2 + 1] = 101;
        int n2 = 1;
        for (int j = 0; j < 100; ++j) {
            if (n < nextInt2 && j + 1 == a[n]) {
                ++n;
            }
            else {
                array2[n2] = j + 1;
                ++n2;
            }
        }
        int x = 100;
        int abs = 100;
        for (int k = array2.length - 1; k >= 0; --k) {
            if (abs >= Math.abs(nextInt - array2[k])) {
                x = array2[k];
                abs = Math.abs(nextInt - array2[k]);
            }
        }
        System.out.println(x);
    }
}