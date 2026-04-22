import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int nextInt;
        do {
            nextInt = scanner.nextInt();
        } while (nextInt > 100);
        int n;
        for (n = 0; (int)Math.pow(2.0, n) <= nextInt; ++n) {}
        --n;
        System.out.println((int)Math.pow(2.0, n));
    }
}