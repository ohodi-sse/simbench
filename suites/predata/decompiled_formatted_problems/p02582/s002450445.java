import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).nextLine().split("");
        int n = 0;
        int x = 0;
        final String[] array2 = split;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if (array2[i].equals("R")) {
                ++n;
            }
            else {
                if (n > x) {
                    x = n;
                }
                n = 0;
            }
        }
        if (n > x) {
            x = n;
        }
        System.out.println(x);
    }
}