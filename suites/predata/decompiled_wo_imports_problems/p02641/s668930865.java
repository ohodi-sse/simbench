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
        int j = 0;
        int n = 0;
        while (j == 0) {
            int n2 = 1;
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - n == array2[k]) {
                    n2 = 0;
                }
            }
            if (n2 == 1) {
                System.out.println(nextInt - n);
                break;
            }
            j = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (nextInt + n == array2[l]) {
                    j = 0;
                }
            }
            if (j == 1) {
                System.out.println(nextInt + n);
                break;
            }
            ++n;
        }
    }
}