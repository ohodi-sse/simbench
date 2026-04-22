import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final char c = 'S';
        final char c2 = 'C';
        final char c3 = 'R';
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i) && nextLine.charAt(i) == c) {
                ++n;
            }
            else if (nextLine.charAt(i) == nextLine2.charAt(i) && nextLine.charAt(i) == c2) {
                ++n2;
            }
            else if (nextLine.charAt(i) == nextLine2.charAt(i) && nextLine.charAt(i) == c3) {
                ++n3;
            }
        }
        System.out.println(n + n2 + n3);
    }
}