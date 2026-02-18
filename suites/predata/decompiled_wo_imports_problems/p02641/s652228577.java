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
        scanner.close();
        int n = 100;
        int x = 0;
        for (int j = -100; j <= 101; ++j) {
            if (!list.contains(j)) {
                int n2;
                if ((n2 = nextInt - j) < 0) {
                    n2 = j - nextInt;
                }
                if (n2 < n) {
                    n = n2;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}