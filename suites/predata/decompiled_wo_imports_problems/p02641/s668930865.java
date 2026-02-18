public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int j = 0;
        int n = 0;
        while (j == 0) {
            int n2 = 1;
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - n == array[k]) {
                    n2 = 0;
                }
            }
            if (n2 == 1) {
                System.out.println(nextInt - n);
                return;
            }
            j = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (nextInt + n == array[l]) {
                    j = 0;
                }
            }
            if (j == 1) {
                System.out.println(nextInt + n);
                return;
            }
            ++n;
        }
    }
}