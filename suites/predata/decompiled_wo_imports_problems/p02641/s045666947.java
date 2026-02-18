public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] a = new Integer[nextInt2 = scanner.nextInt()];
        int n = 1000;
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        for (int j = 0; j < nextInt << 1; ++j) {
            if (!Arrays.asList(a).contains(j)) {
                final int abs = Math.abs(nextInt - j);
                if (n > abs) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}