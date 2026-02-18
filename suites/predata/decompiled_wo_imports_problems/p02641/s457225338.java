public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        int n = 101;
        int n2 = 101;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = nextInt;
        for (int k = 0; k < 100; ++k) {
            if (!list.contains(j)) {
                n = j;
                break;
            }
            ++j;
        }
        int l = nextInt - 1;
        for (int n3 = 0; n3 < 100; ++n3) {
            if (!list.contains(l)) {
                n2 = l;
                break;
            }
            --l;
        }
        if (list.size() == 0) {
            System.out.println(nextInt);
            return;
        }
        if (Math.abs(n - nextInt) < Math.abs(n2 - nextInt)) {
            System.out.println(n);
            return;
        }
        if (Math.abs(n - nextInt) > Math.abs(n2 - nextInt)) {
            System.out.println(n2);
            return;
        }
        if (n < n2) {
            System.out.println(n);
            return;
        }
        if (n2 < n) {
            System.out.println(n2);
        }
    }
}