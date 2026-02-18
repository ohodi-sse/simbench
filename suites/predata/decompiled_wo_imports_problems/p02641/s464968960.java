public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int j = 0; j < nextInt2; ++j) {
            int n = 0;
            int n2 = 0;
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - j != array[k]) {
                    ++n;
                }
                if (nextInt + j != array[k]) {
                    ++n2;
                }
            }
            if (n == nextInt2) {
                System.out.println(nextInt - j);
                return;
            }
            if (n2 == nextInt2) {
                System.out.println(nextInt + j);
                return;
            }
        }
        System.out.println(nextInt - 1);
    }
}