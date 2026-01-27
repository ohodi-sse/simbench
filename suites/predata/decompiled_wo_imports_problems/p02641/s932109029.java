public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[202];
        int n = 1000;
        final int n2 = nextInt;
        int n3 = 0;
        for (int i = -100; i <= 101; ++i) {
            array3[n3] = Math.abs(nextInt - i);
            ++n3;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array3[scanner.nextInt() + 100] = 1000;
        }
        for (int k = 0; k < array3.length; ++k) {
            if (n > array3[k]) {
                n = array3[k];
            }
        }
        int x = n2 - n;
        if (array3[x + 100] == 1000) {
            x = nextInt + n;
        }
        if (nextInt2 == 0) {
            x = nextInt;
        }
        System.out.println(x);
    }
}