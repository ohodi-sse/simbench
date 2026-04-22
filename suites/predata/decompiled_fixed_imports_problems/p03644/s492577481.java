import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int i = 2;
        int x = 0;
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            while (i <= nextInt) {
                x = i;
                i *= 2;
            }
            System.out.println(x);
        }
    }
}