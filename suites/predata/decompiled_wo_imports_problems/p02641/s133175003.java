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
        final int[] array = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 1;
        }
        int n = 999;
        int x = 0;
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (array[j] != 1 && (abs = Math.abs(nextInt - j)) < n) {
                n = abs;
                x = j;
            }
        }
        System.out.println(x);
    }
}