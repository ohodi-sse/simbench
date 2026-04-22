import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println((int)Math.pow(2.0, (int)(Math.log10(scanner.nextInt()) / Math.log10(2.0))));
        scanner.close();
    }
}