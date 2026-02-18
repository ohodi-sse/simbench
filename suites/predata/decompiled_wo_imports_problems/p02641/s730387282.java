public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        final ArrayList c = new ArrayList(array.length);
        for (int j = 0; j < array.length; ++j) {
            c.add((Object)array[j]);
        }
        for (int k = 1; k < nextInt + 1; ++k) {
            for (int l = -1; l < 2; ++l) {
                final int n = nextInt + l * k;
                if (Collections.frequency(c, n) == 0) {
                    System.out.println(n);
                    System.exit(0);
                }
            }
        }
    }
}