import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (int)Math.floor(500.0 * scanner.nextDouble()) / 500L);
    }
}