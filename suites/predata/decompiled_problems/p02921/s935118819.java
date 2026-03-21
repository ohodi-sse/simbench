import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final char[] array2 = new char[3];
        final char[] array3 = new char[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            array2[i] = next.charAt(i);
        }
        for (int j = 0; j < 3; ++j) {
            array3[j] = next2.charAt(j);
        }
        for (int k = 0; k < 3; ++k) {
            if (array2[k] == array3[k]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}