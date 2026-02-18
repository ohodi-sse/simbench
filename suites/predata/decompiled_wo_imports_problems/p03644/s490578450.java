final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        final int[] array;
        final int length = (array = new int[] { 1, 2, 4, 8, 16, 32, 64 }).length;
        int n = 7;
        int n2 = 0;
        while (n2 + 1 != n) {
            if (int1 >= array[(n + n2) / 2]) {
                n2 = (n + n2) / 2;
            }
            else {
                n = (n + n2) / 2;
            }
        }
        System.out.println(array[n2]);
    }
}