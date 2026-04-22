import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        for (int i = 1; i <= 7; ++i) {
            if (Math.pow(2.0, i) > nextInt) {
                System.out.print((int)Math.pow(2.0, i - 1));
                break;
            }
        }
    }
}