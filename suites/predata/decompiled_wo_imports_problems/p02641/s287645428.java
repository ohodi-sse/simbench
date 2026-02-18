public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array = new int[102];
        for (int i = 0; i < 102; ++i) {
            array[i] = 0;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array[scanner.nextInt()] = 1;
        }
        if (array[nextInt] == 0) {
            System.out.println(nextInt);
            return;
        }
        int k;
        int l;
        for (k = nextInt + 1, l = nextInt - 1; k <= 101 && l >= 0; ++k, --l) {
            if (array[l] == 0) {
                System.out.println(l);
                return;
            }
            if (array[k] == 0) {
                System.out.println(k);
                return;
            }
        }
        while (k == 102) {
            if (array[l] == 0) {
                System.out.println(l);
                return;
            }
            --l;
        }
        while (l == -1) {
            if (array[k] == 0) {
                System.out.println(k);
                return;
            }
            ++k;
        }
    }
}