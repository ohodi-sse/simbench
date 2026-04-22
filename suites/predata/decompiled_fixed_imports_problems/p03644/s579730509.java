import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int n = 2;
        final int nextInt = scanner.nextInt();
        for (int i = 0; i < 7; ++i) {
            if (nextInt == 1) {
                break;
            }
            if (nextInt < n) {
                break;
            }
            n *= 2;
        }
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(n / 2);
        }
        scanner.close();
    }
}