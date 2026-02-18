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
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n;
        for (n = 0; list.contains(nextInt - n); ++n) {
            if (!list.contains(nextInt + n)) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}