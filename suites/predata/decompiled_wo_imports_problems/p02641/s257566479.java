public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        final int[] array2 = new int[102];
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        for (int j = 0; j < 102; ++j) {
            if (array2[j] != 1) {
                if (nextInt - x > Math.abs(nextInt - j)) {
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}