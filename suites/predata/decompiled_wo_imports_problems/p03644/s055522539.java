public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int[] array2 = new int[6];
        array2[0] = 2;
        for (int i = 1; i < 6; ++i) {
            array2[i] = array2[i - 1] * 2;
        }
        if (nextInt == 1) {
            System.out.print(1);
        }
        else if (array2[5] <= nextInt) {
            System.out.print(array2[5]);
        }
        else {
            for (int j = 0; j < 6; ++j) {
                if (nextInt < array2[j]) {
                    System.out.print(array2[j - 1]);
                    break;
                }
            }
        }
        scanner.close();
    }
}