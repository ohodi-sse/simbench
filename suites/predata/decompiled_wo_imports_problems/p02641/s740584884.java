public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        int abs = 200;
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < 102; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (array[k] == j) {
                    b = false;
                }
            }
            if (b && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}