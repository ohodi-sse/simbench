import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        int i;
        int n;
        for (i = 0, n = 0; i <= nextInt; i = (int)Math.pow(2.0, n)) {
            ++n;
        }
        System.out.println((int)Math.pow(2.0, n - 1));
    }
}