public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Integer[] array2 = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j < 1000; ++j) {
            if (!Arrays.asList(array2).contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!Arrays.asList(array2).contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}