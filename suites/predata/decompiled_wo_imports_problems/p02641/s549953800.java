public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final boolean[] array2 = new boolean[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[array[i] = scanner.nextInt()] = true;
        }
        for (int j = 0; j < nextInt + 1; ++j) {
            if (!array2[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (!array2[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
        int x;
        if (nextInt > 50) {
            x = 101;
        }
        else {
            x = -1;
        }
        System.out.println(x);
    }
}