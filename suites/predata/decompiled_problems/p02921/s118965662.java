import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int length = charArray.length, i = 0; i < length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}