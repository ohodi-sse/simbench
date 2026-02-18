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
        for (int j = 0; j < 100; ++j) {
            if (!list.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!list.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}