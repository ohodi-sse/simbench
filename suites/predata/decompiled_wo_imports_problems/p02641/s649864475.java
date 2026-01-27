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
                if (nextInt - a[0] <= a[nextInt2 - 1] - nextInt) {
                    x = 9;
                }
                else {
                    x = 9;
                }
            }
        }
        System.out.println(x);
    }
}