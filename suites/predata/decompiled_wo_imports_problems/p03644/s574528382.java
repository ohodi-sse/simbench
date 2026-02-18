public final class Main
{
    private static void main$3231c38a() {
        int i = new Scanner(System.in).nextInt();
        final int[] array = { 1, 2, 4, 8, 16, 32, 64 };
        while (i > 0) {
            final int length = array.length;
            for (int j = 6; j >= 0; --j) {
                if (i == array[j]) {
                    System.out.println(array[j]);
                    return;
                }
            }
            --i;
        }
    }
}