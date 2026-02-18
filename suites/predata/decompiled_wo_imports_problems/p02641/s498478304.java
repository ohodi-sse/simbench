public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            final int n;
            if ((n = scanner.nextInt() - nextInt) >= 0) {
                list.add(n);
            }
            else {
                list2.add(n);
            }
        }
        int n2 = 0;
        for (int j = 0; j < 101; ++j) {
            boolean b = true;
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (j == (int)iterator.next()) {
                    b = false;
                }
            }
            if (b) {
                n2 = j;
                break;
            }
        }
        int a = -101;
        for (int k = -1; k > -101; --k) {
            boolean b2 = true;
            final Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                if (k == (int)iterator2.next()) {
                    b2 = false;
                }
            }
            if (b2) {
                a = k;
                break;
            }
        }
        final int abs = Math.abs(a);
        if (n2 == abs) {
            System.out.println(nextInt + a);
            return;
        }
        if (n2 > abs) {
            System.out.println(nextInt + a);
            return;
        }
        System.out.println(nextInt + n2);
    }
}