public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            final int nextInt3 = scanner.nextInt();
            final int[] array2 = array;
            final int n = nextInt3;
            ++array2[n];
        }
        int x;
        for (x = nextInt; x >= 0 && array[x] != 0; --x) {}
        int x2;
        for (x2 = nextInt + 1; x2 < 102 && array[x2] != 0; ++x2) {}
        if (x2 - nextInt < nextInt - x) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}