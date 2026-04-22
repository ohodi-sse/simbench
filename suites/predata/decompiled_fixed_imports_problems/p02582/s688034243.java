import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        int x2 = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++x2;
            }
            else if (x < x2) {
                x = x2;
                x2 = 0;
            }
        }
        if (x < x2) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}