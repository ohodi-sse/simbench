public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int n = 0;
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= list.size(); ++j) {
            if (n == 0) {
                if (!list.contains(nextInt + j)) {
                    list2.add(nextInt + j);
                    n = 1;
                }
                if (!list.contains(nextInt - j)) {
                    list2.add(nextInt - j);
                    n = 1;
                }
                if (n == 1) {
                    break;
                }
            }
        }
        Collections.sort((List<Comparable>)list2);
        if (nextInt2 > 0) {
            System.out.println(list2.get(0));
            return;
        }
        System.out.println(nextInt);
    }
}