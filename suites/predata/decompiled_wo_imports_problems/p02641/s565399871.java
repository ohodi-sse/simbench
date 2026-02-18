final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (list.size() == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        list2.add(list.get(0) - 2);
        for (int j = 0; j < nextInt2; ++j) {
            if ((int)list.get(j) < nextInt) {
                list2.add(list.get(j));
            }
            else if ((int)list.get(j) > nextInt) {
                list3.add(list.get(j));
            }
            else {
                ++n;
            }
        }
        list3.add((int)list.get(nextInt2 - 1) + 2);
        int x = 0;
        int x2 = 0;
        for (int k = 1; k < list2.size() + 1; ++k) {
            final int n4 = nextInt - k;
            final ArrayList list4 = list2;
            if (n4 > (int)list4.get(list4.size() - k)) {
                ++n2;
                x = nextInt - k;
                break;
            }
        }
        if (n2 == 0) {
            x = list2.get(0) - 1;
        }
        for (int l = 1; l < list3.size() + 1; ++l) {
            if (nextInt + l < (int)list3.get(l - 1)) {
                ++n3;
                x2 = nextInt + l;
                break;
            }
        }
        if (n3 == 0) {
            final ArrayList list5 = list2;
            x2 = (int)list5.get(list5.size() - 1) + 1;
        }
        if (n == 0) {
            System.out.println(nextInt);
            return;
        }
        if (nextInt - x >= x2 - nextInt && nextInt - x > x2 - nextInt) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}