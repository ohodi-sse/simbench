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
        int n = nextInt - 1;
        int n2 = nextInt + 1;
        if (set.isEmpty() || !set.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        while (set.contains(n)) {
            --n;
            if (!set.contains(n2)) {
                System.out.println(n2);
                return;
            }
            ++n2;
        }
        System.out.println(n);
    }
}