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
        int x = -1;
        int n = 100;
        if (nextInt2 == 0) {
            x = nextInt;
        }
        else if (nextInt < a[0]) {
            x = nextInt;
        }
        else if (nextInt > a[nextInt2 - 1]) {
            x = nextInt;
        }
        else if (nextInt == a[0]) {
            x = nextInt - 1;
        }
        else if (a[nextInt2 - 1] == nextInt && a[nextInt2 - 1] - a[nextInt2 - 2] <= 1) {
            x = nextInt + 1;
        }
        else {
            for (int j = 0; j < nextInt2 - 1; ++j) {
                final int n2 = a[j];
                final int n3 = a[j + 1];
                if (n3 > nextInt && n2 < nextInt) {
                    x = nextInt;
                }
                else if (n2 >= nextInt && n > n2 + 1 - nextInt) {
                    if (n3 - n2 > 1) {
                        x = n2 + 1;
                        n = x - nextInt;
                    }
                }
                else {
                    if (n2 >= nextInt && n < n2 + 1 - nextInt) {
                        break;
                    }
                    if (n3 <= nextInt && n > nextInt - (n3 - 1)) {
                        if (n3 - n2 > 1) {
                            x = n3 - 1;
                            n = nextInt - x;
                        }
                    }
                    else if (n3 <= nextInt && n < nextInt - (n3 - 1)) {
                        break;
                    }
                }
            }
        }
        if (x == -1) {
            if (Math.abs(a[0] - 1 - nextInt) <= Math.abs(a[nextInt2 - 1] + 1 - nextInt)) {
                x = a[0] - 1;
            }
            else {
                x = a[nextInt2 - 1] + 1;
            }
        }
        System.out.println(x);
    }
}