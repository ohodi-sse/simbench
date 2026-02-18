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
        Arrays.sort(a);
        int min = nextInt;
        int abs = nextInt2;
        for (int j = 0; j <= 101; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (a[k] == j) {
                    b = false;
                    break;
                }
            }
            if (b) {
                if (Math.abs(nextInt - j) < abs) {
                    abs = Math.abs(nextInt - j);
                    min = j;
                }
                else if (Math.abs(nextInt - j) == abs) {
                    min = Math.min(min, j);
                }
            }
        }
        System.out.println(min);
    }
}