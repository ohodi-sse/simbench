public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        int n = 0;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        while (list.contains(nextInt + n)) {
            if (n < 0) {
                n = -n;
            }
            else {
                n = -(n + 1);
            }
        }
        System.out.println(nextInt + n);
    }
}