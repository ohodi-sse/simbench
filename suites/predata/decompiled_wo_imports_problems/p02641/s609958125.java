public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        int x = 0;
        int abs = 100;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = -100; j <= 101; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (j == array[k]) {
                    b = false;
                }
            }
            if (b && Math.abs(j - nextInt) < abs) {
                x = j;
                abs = Math.abs(j - nextInt);
            }
        }
        System.out.println(x);
    }
}