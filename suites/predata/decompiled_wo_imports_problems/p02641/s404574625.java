public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[array[i] = scanner.nextInt()] = 1;
        }
        int abs = 1000;
        int x = nextInt;
        for (int j = 0; j <= 101; ++j) {
            if (array2[j] == 0 && Math.abs(nextInt - j) < abs) {
                x = j;
                abs = Math.abs(nextInt - j);
            }
        }
        System.out.println(x);
    }
}