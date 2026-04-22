import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int x = 0;
        for (int length = next.length(), i = 0; i < length; ++i) {
            if (next.substring(i, i + 1).equals(next2.substring(i, i + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}