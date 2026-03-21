import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (long)((scanner.nextFloat() + 1.0E-4f) * 100.0f / 1.0f) / 100L);
    }
}