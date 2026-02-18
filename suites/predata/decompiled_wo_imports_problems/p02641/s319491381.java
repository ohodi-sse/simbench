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
        final int[] array = new int[103];
        for (int i = 0; i < 103; ++i) {
            final int[] array2 = array;
            final int n = i;
            array2[n] = n - 1;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array[scanner.nextInt() + 1] = -2;
        }
        if (array[nextInt + 1] != -2) {
            System.out.println(nextInt);
            return;
        }
        int n2 = 104;
        int x = -3;
        for (int k = 0; k < 103; ++k) {
            if (array[k] != -2) {
                int n3;
                if ((n3 = nextInt - array[k]) == 0) {
                    System.out.println(nextInt);
                    return;
                }
                if (n3 < 0) {
                    n3 = -n3;
                }
                if (n3 < n2) {
                    n2 = n3;
                    x = array[k];
                }
            }
        }
        System.out.println(x);
    }
}