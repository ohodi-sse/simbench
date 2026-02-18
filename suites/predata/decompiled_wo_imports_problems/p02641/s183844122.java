public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array = new int[102];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 1;
        }
        int n = 0;
        int n2 = 0;
        int x = 0;
        int x2 = 0;
        for (int j = nextInt; j < array.length; ++j) {
            if (array[j] == 0) {
                n2 = j - nextInt;
                x2 = j;
                break;
            }
        }
        for (int k = nextInt; k >= 0; --k) {
            if (array[k] == 0) {
                n = nextInt - k;
                x = k;
                break;
            }
        }
        if (n > n2) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}