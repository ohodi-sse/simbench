import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64, 128 };
        for (int i = 0; i < 8; ++i) {
            if (array2[i] > nextInt) {
                System.out.println(array2[i - 1]);
                return;
            }
        }
    }
}