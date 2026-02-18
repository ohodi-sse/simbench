public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int n;
        for (n = 0; set.contains(nextInt - n); ++n) {
            if (!set.contains(nextInt + n)) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}