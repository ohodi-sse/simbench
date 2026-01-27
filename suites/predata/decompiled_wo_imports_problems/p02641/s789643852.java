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
        int n = 1;
        for (int j = 0; j < nextInt2; ++j) {
            if (nextInt == a[j]) {
                n = 0;
                break;
            }
        }
        if (n == 1) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int k = 1; k < 100; ++k) {
            final int x = nextInt - k;
            int n2 = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (x == a[l]) {
                    n2 = 0;
                    break;
                }
            }
            if (n2 == 1) {
                System.out.println(x);
                System.exit(0);
            }
            final int x2 = nextInt + k;
            int n3 = 1;
            for (int n4 = 0; n4 < nextInt2; ++n4) {
                if (x2 == a[n4]) {
                    n3 = 0;
                    break;
                }
            }
            if (n3 == 1) {
                System.out.println(x2);
                System.exit(0);
            }
        }
    }
}