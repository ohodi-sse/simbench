public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64 };
        for (int i = 6; i >= 0; --i) {
            if (nextInt >= array2[i]) {
                System.out.println(array2[i]);
                break;
            }
        }
    }
}