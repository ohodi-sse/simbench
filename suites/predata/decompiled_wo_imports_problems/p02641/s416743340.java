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
        int x = nextInt;
        for (int j = 0; j < 101; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (array[k] == x) {
                    b = false;
                }
            }
            if (b) {
                System.out.println(x);
                return;
            }
            if (j % 2 == 0) {
                x -= j + 1;
            }
            else {
                x += j + 1;
            }
        }
    }
}