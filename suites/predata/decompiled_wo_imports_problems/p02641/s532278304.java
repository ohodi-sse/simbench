public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.print(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int abs = 101;
        int j = nextInt;
        for (int k = 0; k <= 101; ++k) {
            if (!set.contains(k) && Math.abs(nextInt - k) < abs) {
                abs = Math.abs(nextInt - k);
                j = k;
            }
        }
        System.out.print(j);
    }
}