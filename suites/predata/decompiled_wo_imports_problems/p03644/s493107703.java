public final class Main
{
    private static void main$3231c38a() throws NumberFormatException, IOException {
        final int[] array = { 64, 32, 16, 8, 4, 2, 1 };
        final int int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        for (int i = 0; i < array.length; ++i) {
            if (int1 >= array[i]) {
                System.out.println(array[i]);
                return;
            }
        }
    }
}