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
        int x = nextInt;
        int n = Integer.MAX_VALUE;
        for (int j = 0; j <= 200; ++j) {
            final int abs;
            if (!set.contains(j) && (abs = Math.abs(nextInt - j)) < n) {
                x = j;
                n = abs;
            }
        }
        System.out.println(x);
    }
}