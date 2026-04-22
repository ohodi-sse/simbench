import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64 };
    Label_0107:
        for (int i = nextInt; i > 0; --i) {
            for (int j = array2.length - 1; j >= 0; --j) {
                if (i == array2[j]) {
                    System.out.println(array2[j]);
                    break Label_0107;
                }
            }
        }
    }
}