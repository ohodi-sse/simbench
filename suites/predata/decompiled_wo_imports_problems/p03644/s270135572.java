final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array = { 1, 2, 4, 8, 16, 32, 64 };
        int x = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] <= nextInt) {
                x = array[i];
            }
        }
        System.out.println(x);
    }
}