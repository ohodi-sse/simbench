public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        int x = nextInt;
        int x2 = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < nextInt2; ++j) {
            if (x == array[j]) {
                ++x;
                j = -1;
            }
        }
        for (int k = 0; k < nextInt2; ++k) {
            if (x2 == array[k] && x2 > 0) {
                --x2;
                k = -1;
            }
        }
        if (Math.abs(x - nextInt) >= Math.abs(x2 - nextInt)) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}