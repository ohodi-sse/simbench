import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int x = 1;
        while (nextInt / 2 > 0) {
            x *= 2;
            nextInt /= 2;
        }
        System.out.println(x);
        scanner.close();
    }
}