import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String next = scanner.next();
        final char[] array2 = new char[3];
        final char[] array3 = new char[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            array2[i] = nextLine.charAt(i);
            array3[i] = next.charAt(i);
            if (array2[i] == array3[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}