public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        int x = nextInt;
        int n = 1;
        int i = 1;
        for (int j = 0; j < nextInt2; ++j) {
            array[j] = scanner.nextInt();
        }
        for (int k = 0; k < nextInt2; ++k) {
            if (array[k] == nextInt) {
                i = 0;
                break;
            }
        }
        while (i == 0) {
            int n2 = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (array[l] == nextInt - n) {
                    n2 = 0;
                    break;
                }
            }
            if (n2 == 1) {
                x = nextInt - n;
                break;
            }
            i = 1;
            for (int n3 = 0; n3 < nextInt2; ++n3) {
                if (array[n3] == nextInt + n) {
                    i = 0;
                    break;
                }
            }
            if (i == 1) {
                x = nextInt + n;
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}