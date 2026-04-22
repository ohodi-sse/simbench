import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int x = 0;
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}