public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        final HashSet set2 = new HashSet();
        int abs = 1000;
        int n = 0;
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        for (int j = 0; j < 100; ++j) {
            if (!set.contains(j + 1)) {
                set2.add(j + 1);
            }
        }
        final Iterator iterator = set2.iterator();
        while (iterator.hasNext()) {
            final int intValue;
            if (Math.abs((intValue = (int)iterator.next()) - nextInt) < abs) {
                abs = Math.abs(intValue - nextInt);
                n = intValue;
            }
        }
        if (nextInt <= 50) {
            if (nextInt <= Math.abs(n - nextInt)) {
                System.out.println(0);
                return;
            }
            System.out.println(n);
        }
        else {
            if (101 - nextInt < Math.abs(n - nextInt)) {
                System.out.println(101);
                return;
            }
            System.out.println(n);
        }
    }
}