import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        int x = 0;
        for (int i = 0; i < nextInt; ++i) {
            x = (int)Math.pow(2.0, i);
            if (x > nextInt) {
                x = (int)Math.pow(2.0, i - 1);
                break;
            }
        }
        System.out.println(x);
    }
}