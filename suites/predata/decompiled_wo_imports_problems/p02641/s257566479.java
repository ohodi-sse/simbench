public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        final int[] array = new int[102];
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 1;
        }
        for (int j = 0; j < 102; ++j) {
            if (array[j] != 1 && nextInt - x > Math.abs(nextInt - j)) {
                x = j;
            }
        }
        System.out.println(x);
    }
}