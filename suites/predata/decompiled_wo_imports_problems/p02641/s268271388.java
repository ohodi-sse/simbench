public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] array = new Integer[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        if (!checkForbiddenList(array, nextInt)) {
            System.out.println(nextInt);
            return;
        }
        int x = 0;
        for (int j = 0; j < 100; ++j) {
            if (!checkForbiddenList(array, nextInt - j)) {
                x = nextInt - j;
                break;
            }
            if (!checkForbiddenList(array, nextInt + j)) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
    
    private static boolean checkForbiddenList(final Integer[] a, final int i) {
        return Arrays.asList(a).contains(i);
    }
}