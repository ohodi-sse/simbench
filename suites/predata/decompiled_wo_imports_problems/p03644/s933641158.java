public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = new int[nextInt];
        for (int i = 1; i <= nextInt; ++i) {
            for (int n = i; i != 0 && n % 2 == 0; n /= 2) {
                final int[] array3 = array2;
                final int n2 = i - 1;
                ++array3[n2];
            }
        }
        int n3 = array2[0];
        int n4 = 0;
        for (int j = 1; j < nextInt; ++j) {
            if (array2[j] > n3) {
                n3 = array2[j];
                n4 = j;
            }
        }
        System.out.println(n4 + 1);
    }
}