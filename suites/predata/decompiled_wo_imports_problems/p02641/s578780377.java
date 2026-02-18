public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
            set.add(array[i]);
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int j = 0; j <= 100; ++j) {
            if (!set.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!set.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}