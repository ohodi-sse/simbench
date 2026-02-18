public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        int i = 0;
        int abs = 101;
        for (int j = 0; j < nextInt2; ++j) {
            list.add(scanner.nextInt());
        }
        for (int k = -1; k <= 200; ++k) {
            if (!list.contains(k) && Math.abs(k - nextInt) < abs) {
                i = k;
                abs = Math.abs(k - nextInt);
            }
        }
        System.out.print(i);
    }
}