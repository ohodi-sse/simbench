import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'S') {
                n = 0;
            }
            else if (++n > x) {
                x = n;
            }
        }
        System.out.println(x);
    }
}