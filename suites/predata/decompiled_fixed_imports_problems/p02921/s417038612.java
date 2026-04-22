import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String s = new String();
        final String s2 = new String();
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final char[] charArray = nextLine.toCharArray();
        final char[] charArray2 = nextLine2.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}