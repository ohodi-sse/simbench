public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            final int nextInt3;
            if ((nextInt3 = scanner.nextInt()) < nextInt) {
                a[i] = Math.abs(nextInt - nextInt3) << 1;
            }
            else {
                a[i] = (Math.abs(nextInt - nextInt3) << 1) + 1;
            }
        }
        Arrays.sort(a);
        int n = 1;
        for (int n2 = 0; n2 < nextInt2 && a[n2] == n; ++n, ++n2) {}
        int x;
        if (n % 2 == 0) {
            x = nextInt - n / 2;
        }
        else {
            x = nextInt + n / 2;
        }
        System.out.println(x);
    }
}