public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n = Integer.MAX_VALUE;
        int x = -1;
        for (int j = -5; j <= 105; ++j) {
            if (!list.contains(j)) {
                final int abs = Math.abs(j - nextInt);
                if (n > abs) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}