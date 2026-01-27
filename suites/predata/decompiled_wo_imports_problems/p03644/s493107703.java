public class Main
{
    public static void main(final String[] array) throws NumberFormatException, IOException {
        final int[] array2 = { 64, 32, 16, 8, 4, 2, 1 };
        final int int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        for (int i = 0; i < array2.length; ++i) {
            if (int1 >= array2[i]) {
                System.out.println(array2[i]);
                break;
            }
        }
    }
}