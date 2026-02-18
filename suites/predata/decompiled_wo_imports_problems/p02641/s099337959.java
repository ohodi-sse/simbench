public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final boolean[] array = new boolean[102];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = true;
        }
        int x = -1;
        int abs = Math.abs(nextInt + 1);
        for (int j = 0; j <= 101; ++j) {
            final int abs2;
            if (!array[j] && (abs2 = Math.abs(nextInt - j)) < abs) {
                abs = abs2;
                x = j;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}