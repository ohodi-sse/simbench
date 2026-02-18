public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int x = 0;
        int x2 = 101;
        final Integer[] a = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int j = 1; j <= 101; ++j) {
            if (!Arrays.asList(a).contains(j)) {
                x = ((x <= j && j <= nextInt) ? j : x);
                x2 = ((j <= x2 && j >= nextInt) ? j : x2);
            }
        }
        if (Math.abs(x - nextInt) <= Math.abs(x2 - nextInt)) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}