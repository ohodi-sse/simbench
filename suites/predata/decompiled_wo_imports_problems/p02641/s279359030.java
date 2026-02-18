final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int nextInt;
        final int n = nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        int abs = 0;
        int x = n;
    Label_0261:
        for (int j = 0; j < list.size(); ++j) {
            if (n <= (int)list.get(j) || j >= list.size()) {
                for (int k = j; k >= 0; --k) {
                    if (nextInt - (int)list.get(k) == 0) {
                        --nextInt;
                    }
                    else if (nextInt > (int)list.get(k)) {
                        break;
                    }
                }
                abs = Math.abs(n - nextInt);
                x = nextInt;
                nextInt = n;
                for (int l = j; l < list.size(); ++l) {
                    if (nextInt - (int)list.get(l) == 0) {
                        ++nextInt;
                    }
                    else if (nextInt < (int)list.get(l) || nextInt > n + abs - 1) {
                        break Label_0261;
                    }
                    if (l >= list.size() - 1) {
                        break Label_0261;
                    }
                }
            }
        }
        if (Math.abs(nextInt - n) < abs) {
            x = nextInt;
        }
        System.out.println(x);
    }
}