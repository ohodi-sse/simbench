public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        int abs = 99;
        int x = 100;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= 200; ++j) {
            if (!list.contains(j) && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        if (nextInt2 == 0 || !list.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        System.out.println(x);
    }
}