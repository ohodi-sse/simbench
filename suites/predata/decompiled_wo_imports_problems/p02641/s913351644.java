public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int abs = 99999;
        int j = nextInt;
        for (int k = 0; k <= 101; ++k) {
            if (!set.contains(k) && Math.abs(k - nextInt) < abs) {
                j = k;
                abs = Math.abs(k - nextInt);
            }
        }
        System.out.print(j);
    }
}