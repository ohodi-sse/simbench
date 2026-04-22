import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (long)((float)(scanner.nextFloat() + 0.001) * 100.0f) / 100L);
    }
}