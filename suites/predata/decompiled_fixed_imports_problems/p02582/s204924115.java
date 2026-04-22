import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        final char[] charArray = next.toCharArray();
        if (charArray[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            x = 3;
        }
        else if (charArray[0] == 'R' && charArray[1] == 'R') {
            x = 2;
        }
        else if (charArray[1] == 'R' && charArray[2] == 'R') {
            x = 2;
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            x = 1;
        }
        System.out.println(x);
    }
}