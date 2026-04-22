import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).nextLine().toCharArray();
        int max = 0;
        int b = 0;
        final char[] array2 = charArray;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if (array2[i] == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        System.out.println(max);
    }
}