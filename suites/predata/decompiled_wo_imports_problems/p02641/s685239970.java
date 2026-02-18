public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array = new int[102];
        int i = 0;
        for (int j = 0; j < nextInt2; ++j) {
            array[scanner.nextInt()] = 1;
        }
        for (int k = 0; k < 102; ++k) {
            if (nextInt - k >= 0 && array[nextInt - k] == 0) {
                i = nextInt - k;
                break;
            }
            if (nextInt + k < 102 && array[nextInt + k] == 0) {
                i = nextInt + k;
                break;
            }
        }
        System.out.print(i);
        scanner.close();
    }
}