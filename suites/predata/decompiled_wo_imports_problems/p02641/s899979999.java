public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int i = 1; i <= nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        if (!list.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        int n = Math.abs(nextInt);
        int x = 0;
        for (int j = nextInt - 1; j >= 0; --j) {
            if (!list.contains(j)) {
                x = j;
                n = Math.abs(nextInt - j);
                break;
            }
        }
        int n2 = Math.abs(101 - nextInt);
        int x2 = 101;
        for (int k = nextInt + 1; k <= 101; ++k) {
            if (!list.contains(k)) {
                x2 = k;
                n2 = Math.abs(nextInt - k);
                break;
            }
        }
        if (n >= n2 && n > n2) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}