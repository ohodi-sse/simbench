import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final char char1 = next.charAt(0);
        final char char2 = next.charAt(1);
        final char char3 = next.charAt(2);
        final char c = 'R';
        if (char1 == char2 && char2 == char3 && char3 == c) {
            System.out.println("3");
        }
        else if ((char1 == char2 && char2 == c) || (char2 == char3 && char3 == c)) {
            System.out.println("2");
        }
        else if (char1 != c && char2 != c && char3 != c) {
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }
    }
}