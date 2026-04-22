import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        final char[] array2 = new char[next.length()];
        for (int i = 0; i < next.length(); ++i) {
            array2[i] = next.charAt(i);
        }
        int x = -1;
        if (array2[0] != 'R' && array2[1] != 'R' && array2[2] != 'R') {
            x = 0;
        }
        else if ((array2[0] == 'S' && array2[1] == 'S') || (array2[1] == 'S' && array2[2] == 'S') || (array2[2] == 'S' && array2[0] == 'S') || (array2[0] == 'R' && array2[1] == 'S' && array2[2] == 'R')) {
            x = 1;
        }
        else if ((array2[0] == 'R' && array2[1] == 'R' && array2[2] == 'S') || (array2[0] == 'S' && array2[1] == 'R' && array2[2] == 'R')) {
            x = 2;
        }
        else if (array2[0] == 'R' && array2[1] == 'R' && array2[2] == 'R') {
            x = 3;
        }
        System.out.println(x);
    }
}