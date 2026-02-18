public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            final int[] array2 = array;
            final int nextInt3 = scanner.nextInt();
            ++array2[nextInt3];
        }
        if (array[nextInt] == 0) {
            System.out.println(nextInt);
            return;
        }
        int x = 0;
        for (int j = nextInt + 1; j <= 101; ++j) {
            if (array[j] == 0) {
                x = j;
                break;
            }
        }
        int x2 = 0;
        for (int k = nextInt - 1; k >= 0; --k) {
            if (array[k] == 0) {
                x2 = k;
                break;
            }
        }
        if (x - nextInt >= nextInt - x2) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}