public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        int x = -1;
        int abs = 1000;
        final HashSet set = new HashSet();
        for (int j = 0; j < nextInt2; ++j) {
            set.add(array2[j]);
        }
        for (int k = -100; k <= 200; ++k) {
            if (!set.contains(k) && Math.abs(k - nextInt) < abs) {
                abs = Math.abs(k - nextInt);
                x = k;
            }
        }
        System.out.println(x);
    }
}