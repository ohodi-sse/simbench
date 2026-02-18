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
        for (int j = 0; j < 51; ++j) {
            if (!array[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (!array[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}