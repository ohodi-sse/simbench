public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final int[] array2 = new int[202];
        int n = 1000;
        final int n2 = nextInt;
        int n3 = 0;
        for (int i = -100; i <= 101; ++i) {
            array2[n3] = Math.abs(nextInt - i);
            ++n3;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array2[scanner.nextInt() + 100] = 1000;
        }
        for (int k = 0; k < array2.length; ++k) {
            if (n > array2[k]) {
                n = array2[k];
            }
        }
        int x = n2 - n;
        if (array2[x + 100] == 1000) {
            x = nextInt + n;
        }
        if (nextInt2 == 0) {
            x = nextInt;
        }
        System.out.println(x);
    }
}