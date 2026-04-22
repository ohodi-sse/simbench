import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        System.out.println(((charArray[0] == charArray2[0]) + (charArray[1] == charArray2[1]) + (charArray[2] == charArray2[2])) ? 1 : 0);
    }
}