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
        final int[] array = new int[101];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 1;
        }
        for (int j = 0; j < 101; ++j) {
            if (nextInt - j >= 0 && 0 == array[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (nextInt + j >= 101) {
                System.out.println(101);
                return;
            }
            if (0 == array[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}