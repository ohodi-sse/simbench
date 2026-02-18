public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        int x = 0;
        Arrays.sort(a);
        for (int j = 0; j <= 101; ++j) {
            boolean b = false;
            for (int k = 0; k < a.length; ++k) {
                if (j == a[k]) {
                    b = true;
                    break;
                }
            }
            if (!b && Math.abs(nextInt - x) > Math.abs(nextInt - j)) {
                x = j;
            }
        }
        System.out.println(x);
    }
}