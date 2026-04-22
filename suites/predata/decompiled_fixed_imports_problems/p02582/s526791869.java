import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String next = scanner.next();
        int n = 1;
        for (int i = 0; i < 3; ++i) {
            final String substring = next.substring(i, i + 1);
            if (substring.equals("R") && n != 0) {
                ++x;
            }
            else if (substring.equals("R") && n == 0) {
                x = 1;
                n = 1;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}