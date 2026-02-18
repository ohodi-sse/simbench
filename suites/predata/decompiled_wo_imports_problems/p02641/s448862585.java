public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        if (nextInt == 0) {
            System.out.println(nextInt);
            return;
        }
        int abs = Integer.MAX_VALUE;
        int a = 0;
        for (int j = -101; j <= 101; ++j) {
            if (!list.contains(j) && abs > Math.abs(j - nextInt)) {
                abs = Math.abs(j - nextInt);
                a = j;
            }
        }
        int b = 0;
        int abs2 = Integer.MAX_VALUE;
        for (int k = 101; k >= -101; --k) {
            if (!list.contains(k) && abs2 > Math.abs(k - nextInt)) {
                abs2 = Math.abs(k - nextInt);
                b = k;
            }
        }
        System.out.println(Math.min(a, b));
    }
}