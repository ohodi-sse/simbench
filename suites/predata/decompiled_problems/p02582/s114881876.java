import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int a = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++a;
            }
            else {
                a = 0;
            }
            max = Math.max(a, max);
        }
        System.out.println(max);
    }
}