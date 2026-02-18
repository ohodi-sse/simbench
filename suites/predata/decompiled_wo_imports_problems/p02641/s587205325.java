public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] array = new Integer[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        while (true) {
            int n;
            for (n = 0; Arrays.asList(array).contains(nextInt - n); ++n) {
                if (!Arrays.asList(array).contains(nextInt + n)) {
                    final int n2 = n;
                    System.out.println(nextInt + n2);
                    return;
                }
            }
            final int n2 = -n;
            continue;
        }
    }
}