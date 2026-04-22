import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        scanner.close();
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++n;
            }
        }
        if (n == 3) {
            System.out.println("3");
        }
        else if (n == 1) {
            System.out.println("1");
        }
        else if (n == 2) {
            if (charArray[1] == 'S') {
                System.out.println("1");
            }
            else {
                System.out.println("2");
            }
        }
        else {
            System.out.println("0");
        }
    }
}