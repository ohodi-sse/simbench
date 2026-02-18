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
        int n = 0;
        while (true) {
            final int n2 = nextInt - n;
            if (!list.contains(n2)) {
                System.out.println(n2);
                return;
            }
            final int n3 = nextInt + n;
            if (!list.contains(n3)) {
                System.out.println(n3);
                return;
            }
            ++n;
        }
    }
}