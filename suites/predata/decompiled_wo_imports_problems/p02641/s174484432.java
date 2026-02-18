public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final int[] array;
        Arrays.fill(array = new int[201], 1);
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 0;
        }
        for (int j = 0; j <= 200; ++j) {
            if (nextInt - j > 0 && nextInt + j <= 200) {
                if (array[nextInt - j] == 1) {
                    System.out.println(nextInt - j);
                    System.exit(0);
                }
                if (array[nextInt + j] == 1) {
                    System.out.println(nextInt + j);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}




final class Monmo
{
}