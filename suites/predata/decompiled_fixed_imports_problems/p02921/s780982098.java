import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        int x = 0;
        while (i <= 2) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
            ++i;
        }
        System.out.println(x);
    }
}