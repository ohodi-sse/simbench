public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        int abs = 114514893;
        int x = -1;
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        for (int j = -200; j <= 200; ++j) {
            if (!set.contains(j)) {
                if (Math.abs(j - nextInt) < abs) {
                    abs = Math.abs(j - nextInt);
                    x = j;
                }
                else if (Math.abs(j - nextInt) == abs && j < x) {
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}