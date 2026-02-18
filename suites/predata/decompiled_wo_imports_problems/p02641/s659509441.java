public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            final int[] array = new int[102];
            for (int i = 0; i <= 101; ++i) {
                array[i] = Math.abs(nextInt - i);
            }
            for (int j = 0; j < nextInt2; ++j) {
                array[scanner.nextInt()] = Integer.MAX_VALUE;
            }
            int x = 0;
            int n = array[0];
            for (int k = 1; k <= 101; ++k) {
                if (array[k] < n) {
                    x = k;
                    n = array[k];
                }
            }
            System.out.println(x);
        }
    }
}