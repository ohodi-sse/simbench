public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        final int[] array = new int[100 - nextInt2 + 2];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = 0;
        array[0] = 0;
        array[100 - nextInt2 + 1] = 101;
        int n2 = 1;
        for (int j = 0; j < 100; ++j) {
            if (n < nextInt2 && j + 1 == a[n]) {
                ++n;
            }
            else {
                array[n2] = j + 1;
                ++n2;
            }
        }
        int x = 100;
        int abs = 100;
        for (int k = array.length - 1; k >= 0; --k) {
            if (abs >= Math.abs(nextInt - array[k])) {
                x = array[k];
                abs = Math.abs(nextInt - array[k]);
            }
        }
        System.out.println(x);
    }
}