public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int j = 0; j < nextInt2; ++j) {
            int n = 0;
            int n2 = 0;
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - j != array2[k]) {
                    ++n;
                }
                if (nextInt + j != array2[k]) {
                    ++n2;
                }
            }
            if (n == nextInt2) {
                System.out.println(nextInt - j);
                return;
            }
            if (n2 == nextInt2) {
                System.out.println(nextInt + j);
                return;
            }
        }
        System.out.println(nextInt - 1);
    }
}