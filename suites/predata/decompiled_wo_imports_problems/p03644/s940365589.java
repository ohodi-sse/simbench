public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array = { 1, 2, 4, 8, 16, 32, 64 };
        int i = 0;
        for (int j = 0; j < 7; ++j) {
            if (nextInt >= array[j]) {
                i = array[j];
            }
        }
        System.out.print(i);
    }
}