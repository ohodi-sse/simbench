public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int abs = nextInt;
        final int[] array = new int[102];
        int x = 0;
        for (int i = 0; i <= 101; ++i) {
            array[i] = 1;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array[scanner.nextInt()] = 0;
        }
        for (int k = 0; k <= 101; ++k) {
            if (array[k] == 1 && abs > Math.abs(nextInt - k)) {
                abs = Math.abs(nextInt - k);
                x = k;
            }
        }
        System.out.println(x);
    }
}