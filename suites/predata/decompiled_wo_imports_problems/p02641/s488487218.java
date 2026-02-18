public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final Boolean[] array = new Boolean[102];
        for (int i = 0; i < 102; ++i) {
            array[i] = Boolean.TRUE;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array[scanner.nextInt()] = Boolean.FALSE;
        }
        int n = nextInt;
        int n2 = nextInt;
        int n3 = 0;
        int x = nextInt;
        while (!array[nextInt]) {
            if (n3 % 2 == 0) {
                --n2;
                if (array[n2]) {
                    x = n2;
                    break;
                }
            }
            if (n3 % 2 != 0) {
                ++n;
                if (array[n]) {
                    x = n;
                    break;
                }
            }
            ++n3;
        }
        System.out.println(x);
    }
}