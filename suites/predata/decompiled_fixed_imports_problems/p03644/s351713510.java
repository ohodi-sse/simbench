import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        for (int i = 1; i < 9; ++i) {
            if (x == nextInt) {
                break;
            }
            if (x > nextInt) {
                x /= 2;
                break;
            }
            x *= 2;
        }
        System.out.println(x);
    }
}