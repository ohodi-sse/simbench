public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        int abs = 10000;
        int x = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = 0;
        for (int j = -101; j < 102; ++j) {
            if (n < nextInt2 && a[n] == j) {
                ++n;
            }
            else if (Math.abs(j - nextInt) < abs) {
                abs = Math.abs(j - nextInt);
                x = j;
            }
        }
        System.out.println(x);
    }
}