final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        if (!set.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        int n;
        for (n = 1; set.contains(nextInt - n); ++n) {
            if (!set.contains(nextInt + n)) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}