import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        double pow = 1.0;
        if (nextInt == 1) {
            pow = 2.0;
        }
        else {
            for (int i = 0; i < nextInt; ++i) {
                pow = Math.pow(2.0, i);
                if (pow > nextInt) {
                    break;
                }
            }
        }
        System.out.println((int)(pow / 2.0));
    }
}