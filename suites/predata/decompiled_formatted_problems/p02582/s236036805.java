import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++n;
            }
        }
        if (n != 2) {
            System.out.println(n);
        }
        else if (charArray[1] != 'R') {
            System.out.println(1);
        }
        else {
            System.out.println(n);
        }
    }
}