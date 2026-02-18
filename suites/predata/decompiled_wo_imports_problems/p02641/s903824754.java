public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < 105; ++j) {
            final int n = nextInt + j;
            final int n2 = nextInt - j;
            int n3 = 1;
            int n4 = 1;
            for (int n5 = 0; (n3 != 0 || n4 != 0) && n5 != nextInt2; ++n5) {
                if (array[n5] == n) {
                    n3 = 0;
                }
                if (array[n5] == n2) {
                    n4 = 0;
                }
            }
            if (n3 != 0 && n4 != 0) {
                System.out.println(nextInt - j);
                System.exit(0);
            }
            else if (n3 != 0 && n4 == 0) {
                System.out.println(nextInt + j);
                System.exit(0);
            }
            else if (n3 == 0 && n4 != 0) {
                System.out.println(nextInt - j);
                System.exit(0);
            }
        }
    }
}