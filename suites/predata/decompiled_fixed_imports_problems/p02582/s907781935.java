import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String[] split = scanner.next().split("");
        int n = 0;
        scanner.close();
        final String[] array2 = split;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if ("R".equals(array2[i])) {
                if (n != 0) {
                    ++x;
                }
                else {
                    x = 1;
                }
                n = 1;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}