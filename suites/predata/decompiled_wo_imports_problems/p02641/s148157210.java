public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int j = nextInt;
        while (true) {
            while (set.contains(j)) {
                int x;
                if (!set.contains(nextInt - 1)) {
                    x = nextInt - 1;
                }
                else {
                    if (set.contains(j + 1)) {
                        ++j;
                        --nextInt;
                        continue;
                    }
                    x = j + 1;
                }
                System.out.println(x);
                return;
            }
            int x = j;
            continue;
        }
    }
}