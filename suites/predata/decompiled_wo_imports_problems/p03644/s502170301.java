public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        scanner.close();
        final int[] array = new int[int1];
        for (int i = 0; i < int1; ++i) {
            final int[] array2 = array;
            final int n = i;
            array2[n] = n + 1;
        }
        int n2 = 0;
        int n3 = 0;
        int x = 0;
        for (int j = 0; j < int1; ++j) {
            if (int1 == 1) {
                x = 1;
                break;
            }
            for (int n4 = array[j]; n4 % 2 == 0; n4 /= 2, ++n2) {}
            if (n3 < n2) {
                n3 = n2;
                x = array[j];
            }
            n2 = 0;
        }
        System.out.println(x);
    }
}