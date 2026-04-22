import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++x;
                n = 1;
            }
            else if (n == 1) {
                break;
            }
        }
        System.out.println(x);
    }
}