public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            final int nextInt3;
            if ((nextInt3 = scanner.nextInt()) < nextInt) {
                list.add(nextInt3);
            }
            else {
                list2.add(nextInt3);
            }
        }
        scanner.close();
        Collections.sort((List<Comparable>)list);
        Collections.reverse(list);
        Collections.sort((List<Comparable>)list2);
        int n = -1;
        int x = -1;
        for (int j = 0; j < list.size(); ++j) {
            if (nextInt - 1 - j != (int)list.get(j)) {
                n = nextInt - 1 - j;
                break;
            }
        }
        for (int k = 0; k < list2.size(); ++k) {
            if (nextInt + k != (int)list2.get(k)) {
                x = nextInt + k;
                break;
            }
        }
        if (list2.size() <= 0 || list.size() <= 0) {
            if (list2.size() != 0) {
                if (list.size() != 0) {
                    return;
                }
                if (list2.contains(nextInt)) {
                    System.out.println(nextInt - 1);
                    return;
                }
            }
            System.out.println(nextInt);
            return;
        }
        if (n == -1) {
            final ArrayList list3 = list;
            n = (int)list3.get(list3.size() - 1) - 1;
        }
        if (x == -1) {
            final ArrayList list4 = list2;
            x = (int)list4.get(list4.size() - 1) + 1;
        }
        if (nextInt - n < x - nextInt) {
            System.out.println(n);
            return;
        }
        if (nextInt - n > x - nextInt) {
            System.out.println(x);
            return;
        }
        System.out.println(n);
    }
}