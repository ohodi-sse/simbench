import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++x;
            }
            else if (x != 0) {
                break;
            }
        }
        System.out.println(x);
    }
}