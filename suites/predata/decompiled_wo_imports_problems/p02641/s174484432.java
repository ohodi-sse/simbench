public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final int[] a = new int[201];
        Arrays.fill(a, 1);
        for (int i = 0; i < nextInt2; ++i) {
            a[scanner.nextInt()] = 0;
        }
        for (int j = 0; j <= 200; ++j) {
            if (nextInt - j > 0) {
                if (nextInt + j <= 200) {
                    if (a[nextInt - j] == 1) {
                        System.out.println(nextInt - j);
                        System.exit(0);
                    }
                    if (a[nextInt + j] == 1) {
                        System.out.println(nextInt + j);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
}class Monmo
{
}