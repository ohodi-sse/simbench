final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array = { 1, 2, 4, 8, 16, 32, 64 };
        int n = 0;
        for (int n2 = 0; n2 < 7 && array[n2] <= nextInt; ++n2) {
            n = n2;
        }
        System.out.println(array[n]);
    }
}