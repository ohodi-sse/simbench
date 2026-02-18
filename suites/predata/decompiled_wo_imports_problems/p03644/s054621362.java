public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        final int[] array = new int[(nextInt = new Scanner(System.in).nextInt()) + 1];
        for (int i = 1; i <= nextInt; ++i) {
            array[i] = 0;
            int[] array2;
            int n2;
            for (int n = i; n % 2 == 0; n /= 2, array2 = array, n2 = i, ++array2[n2]) {}
        }
        int x = 1;
        int n3 = array[1];
        for (int j = 2; j < nextInt + 1; ++j) {
            if (n3 < array[j]) {
                x = j;
                n3 = array[j];
            }
        }
        System.out.println(x);
    }
}