import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        final char[] array2 = new char[3];
        for (int i = 0; i < 3; ++i) {
            array2[i] = nextLine.charAt(i);
        }
        if (array2[0] == 'R') {
            ++x;
            if (array2[1] == 'R') {
                ++x;
                if (array2[2] == 'R') {
                    ++x;
                }
            }
        }
        else if (array2[1] == 'R') {
            ++x;
            if (array2[2] == 'R') {
                ++x;
            }
        }
        else if (array2[2] == 'R') {
            ++x;
        }
        System.out.println(x);
    }
}