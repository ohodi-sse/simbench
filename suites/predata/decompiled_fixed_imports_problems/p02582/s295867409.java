import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int n = 0;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                x = ++n;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}