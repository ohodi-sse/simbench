import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long x = scanner.nextLong() * (long)(scanner.nextDouble() * 100.0 + 0.001) / 100L;
        scanner.close();
        System.out.println(x);
    }
}