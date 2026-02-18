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
        int x = nextInt;
        Boolean b = Boolean.TRUE;
        for (int n = 0; n <= nextInt && b; ++n) {
            if (!Arrays.asList(array).contains(nextInt - n)) {
                x = nextInt - n;
                b = Boolean.FALSE;
            }
            else if (!Arrays.asList(array).contains(nextInt + n)) {
                x = nextInt + n;
                b = Boolean.FALSE;
            }
        }
        System.out.println(x);
    }
}