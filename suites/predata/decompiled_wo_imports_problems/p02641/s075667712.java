final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n = 0;
        int j = 0;
        int n2 = 0;
        while (j == 0) {
            if (!set.contains(nextInt - n)) {
                j = 1;
            }
            if ((n2 = n) > 0) {
                n = 0 - n;
            }
            else {
                n = 0 - n + 1;
            }
        }
        System.out.println(nextInt - n2);
    }
}