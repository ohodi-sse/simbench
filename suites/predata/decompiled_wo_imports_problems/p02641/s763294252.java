public final class Main
{
    private static void main$3231c38a() {
        int n = 0;
        final Scanner scanner;
        int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        for (int j = 0; j < nextInt2; ++j) {
            if (nextInt == array[j]) {
                int n2 = ++n;
                for (int k = 0; k < n; ++k) {
                    n2 = -n2;
                }
                nextInt += n2;
                j = -1;
            }
        }
        System.out.println(nextInt);
    }
}