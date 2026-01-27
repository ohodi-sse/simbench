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
        int min = Integer.MAX_VALUE;
        for (int j = -1000; j < 1000; ++j) {
            if (!Arrays.asList(array2).contains(j)) {
                min = Math.min(min, Math.abs(nextInt - j));
            }
        }
        final int n = nextInt - min;
        if (Arrays.asList(array2).contains(n)) {
            System.out.println(nextInt + min);
        }
        else {
            System.out.println(n);
        }
    }
}