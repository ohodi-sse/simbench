public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        final int[] array2 = new int[102];
        for (int j = 0; j < 102; ++j) {
            array2[j] = 0;
        }
        for (int k = 0; k < nextInt2; ++k) {
            array2[array[k]] = 1;
        }
        if (array2[nextInt] == 0) {
            System.out.println(nextInt);
            return;
        }
        int l = 0;
        int n = 1;
        while (l == 0) {
            if (array2[nextInt - n] == 0) {
                System.out.println(nextInt - n);
                ++l;
            }
            else if (l == 0 && 101 >= nextInt + n && array2[nextInt + n] == 0) {
                System.out.println(nextInt + n);
                ++l;
            }
            ++n;
        }
    }
}