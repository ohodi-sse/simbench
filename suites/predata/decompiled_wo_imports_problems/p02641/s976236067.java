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
        int x = -100000000;
        int n = 0;
        int n2 = -1000000000;
        int j = 0;
        while (j < 1000) {
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - j == array[k]) {
                    ++n;
                    n2 = array[k];
                }
                else if (nextInt + j == array[k]) {
                    ++n;
                    n2 = array[k];
                }
            }
            if (n == 1 && j != 0) {
                if (n2 == nextInt - j) {
                    x = nextInt + j;
                    break;
                }
                if (n2 == nextInt + j) {
                    x = nextInt - j;
                    break;
                }
                break;
            }
            else {
                if (n == 0) {
                    x = nextInt - j;
                    break;
                }
                n = 0;
                ++j;
            }
        }
        System.out.println(x);
    }
}