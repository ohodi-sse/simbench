public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int j = nextInt;
        int k = nextInt;
        while (set.contains(j)) {
            --j;
        }
        while (set.contains(k)) {
            ++k;
        }
        System.out.println((nextInt - j <= k - nextInt) ? j : k);
    }
}