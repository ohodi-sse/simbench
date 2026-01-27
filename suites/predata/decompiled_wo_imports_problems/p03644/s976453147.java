public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int[] array2 = new int[9];
        final int nextInt = scanner.nextInt();
        int n = 1;
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = n;
            n *= 2;
        }
        for (int j = array2.length - 1; j >= 0; --j) {
            if (array2[j] <= nextInt) {
                System.out.println(array2[j]);
                return;
            }
        }
    }
}