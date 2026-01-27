public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.print(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int abs = 101;
        int j = nextInt;
        for (int k = 0; k <= 101; ++k) {
            if (!set.contains(k) && Math.abs(nextInt - k) < abs) {
                abs = Math.abs(nextInt - k);
                j = k;
            }
        }
        System.out.print(j);
    }
}