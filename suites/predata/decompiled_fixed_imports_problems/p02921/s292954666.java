import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            x += ((charArray[i] == charArray2[i]) ? 1 : 0);
        }
        System.out.println(x);
    }
}