public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = -1;
        boolean b = false;
        for (int j = 0; j < nextInt2; ++j) {
            if (a[j] == nextInt) {
                b = true;
                n = j;
                break;
            }
        }
        int x = 0;
        int n2 = 0;
        for (int k = 0; k < nextInt2; ++k) {
            n2 += a[k];
        }
        if (!b) {
            x = nextInt;
        }
        else if (n2 == nextInt2 * (a[nextInt2 - 1] + a[0]) / 2) {
            if (nextInt - a[0] <= a[nextInt2 - 1] - nextInt) {
                x = a[0] - 1;
            }
            else {
                x = a[nextInt2 - 1] + 1;
            }
        }
        else {
            boolean b2 = false;
            for (int n3 = 1; n3 <= n && n3 <= nextInt2 - 1 - n; ++n3) {
                if (a[n - n3] != a[n] - n3) {
                    x = a[n] - n3;
                    b2 = true;
                    break;
                }
                if (a[n + n3] != a[n] + n3) {
                    x = a[n] + n3;
                    b2 = true;
                    break;
                }
            }
            if (!b2) {
                final int n4 = a[0];
                final int n5 = a[nextInt2 - 1];
                x = 9;
            }
        }
        System.out.println(x);
    }
}