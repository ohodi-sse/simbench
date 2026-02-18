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
        for (int j = 0; j < list.size(); ++j) {
            if (nextInt == (int)list.get(j)) {
                --nextInt;
                list.remove(j);
                j = -1;
            }
        }
        int x = nextInt;
        int n2 = n + 1;
        for (int k = 0; k < list.size(); ++k) {
            if (n2 == (int)list.get(k)) {
                ++n2;
                list.remove(k);
                k = -1;
            }
        }
        if (Math.abs(n2 - n) < Math.abs(x - n)) {
            x = n2;
        }
        System.out.println(x);
    }
}