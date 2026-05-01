import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                if (i == 2 && next.charAt(1) == 'S') {
                    x = 0;
                }
                ++x;
            }
        }
        System.out.println(x);
    }
}