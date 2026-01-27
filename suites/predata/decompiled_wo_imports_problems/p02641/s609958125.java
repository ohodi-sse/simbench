public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        int x = 0;
        int abs = 100;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = -100; j <= 101; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (j == array2[k]) {
                    b = false;
                }
            }
            if (b && Math.abs(j - nextInt) < abs) {
                x = j;
                abs = Math.abs(j - nextInt);
            }
        }
        System.out.println(x);
    }
}