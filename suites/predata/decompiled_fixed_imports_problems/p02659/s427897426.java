import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.printf("%d", scanner.nextLong() * Integer.parseInt(scanner.next().replace(".", "")) / 100L);
    }
}