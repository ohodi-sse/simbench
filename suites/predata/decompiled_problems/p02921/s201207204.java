import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final char[] charArray = nextLine.toCharArray();
        final char[] charArray2 = nextLine2.toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}