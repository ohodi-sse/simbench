public final class Main
{
    private static void main$3231c38a() {
        System.out.println(run());
    }
    
    private static ArrayList<Integer> nScan(final Scanner scanner, final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < n; ++i) {
            list.add(scanner.nextInt());
        }
        return list;
    }
    
    private static Object run() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            final int nextInt2;
            if ((nextInt2 = scanner.nextInt()) == 0) {
                final Integer value = nextInt;
                scanner.close();
                return value;
            }
            final Scanner scanner2 = scanner;
            final int n = nextInt2;
            final Scanner scanner3 = scanner2;
            final ArrayList list = new ArrayList();
            for (int i = 0; i < n; ++i) {
                list.add(scanner3.nextInt());
            }
            ArrayList list2;
            int j;
            for (list2 = list, j = nextInt; list2.contains(j); ++j) {}
            int k = j;
            int l;
            for (l = nextInt; list2.contains(l); --l) {}
            if (k - nextInt >= nextInt - l) {
                k = l;
            }
            return k;
        }
    }
}