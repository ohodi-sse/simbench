public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int n = 105;
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int x = -1;
        if (set.isEmpty()) {
            x = nextInt;
        }
        else {
            for (int j = 0; j <= n; ++j) {
                if (!set.contains(j) && Math.abs(x - nextInt) > Math.abs(j - nextInt)) {
                    x = j;
                }
            }
        }
        System.out.println(x);
        System.out.flush();
        scanner.close();
    }
}