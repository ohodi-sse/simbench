import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (long)(scanner.nextDouble() * 100.0 + 0.5) / 100L);
        scanner.close();
    }
}