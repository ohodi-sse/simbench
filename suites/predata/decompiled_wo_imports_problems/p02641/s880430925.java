public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        boolean b = false;
        int i = nextInt + 100;
        for (int j = 0; j < nextInt2; ++j) {
            array[j] = scanner.nextInt();
            if (nextInt == array[j]) {
                b = true;
            }
        }
        if (!b) {
            System.out.print(nextInt);
            return;
        }
        for (int k = 1; k <= 200 - nextInt; ++k) {
            final int n = nextInt - k;
            final int n2 = nextInt + k;
            if (n <= i || n2 <= i) {
                int n3 = 0;
                int n4 = 0;
                for (int l = 0; l < nextInt2; ++l) {
                    if (array[l] != n) {
                        ++n3;
                    }
                    if (array[l] != n2) {
                        ++n4;
                    }
                }
                if (n3 == nextInt2) {
                    i = n;
                    break;
                }
                if (n4 == nextInt2) {
                    i = n2;
                    break;
                }
            }
        }
        System.out.print(i);
    }
}