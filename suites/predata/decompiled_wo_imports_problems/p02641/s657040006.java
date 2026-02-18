public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int abs = 301;
        final int[] array = new int[nextInt2];
        final int[] array2 = new int[300 - nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int n = 0;
        for (int j = -150; j < 150; ++j) {
            int n2 = 0;
            for (int k = 0; k < nextInt2; ++k) {
                if (j == array[k]) {
                    ++n2;
                    break;
                }
            }
            if (n2 == 0) {
                array2[n] = j;
                ++n;
            }
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int l = 0; l < array2.length; ++l) {
            if (abs <= Math.abs(nextInt - array2[l])) {
                System.out.println(array2[l - 1]);
                return;
            }
            abs = Math.abs(nextInt - array2[l]);
        }
    }
}