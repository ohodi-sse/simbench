public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        int x = 0;
        int n = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 1; j <= 101; ++j) {
            int n2;
            if ((n2 = j - nextInt) < 0) {
                n2 = -n2;
            }
            if (n > n2) {
                boolean b = false;
                for (int k = 0; k < nextInt2; ++k) {
                    if (j == array[k]) {
                        b = true;
                    }
                }
                if (!b) {
                    x = j;
                    n = n2;
                }
            }
        }
        System.out.println(x);
    }
}