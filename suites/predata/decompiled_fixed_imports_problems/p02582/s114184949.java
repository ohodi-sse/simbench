import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int max = 0;
        int n = 0;
        final char[] array2 = charArray;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if (array2[i] == 'R') {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        System.out.println(Math.max(n, max));
    }
}