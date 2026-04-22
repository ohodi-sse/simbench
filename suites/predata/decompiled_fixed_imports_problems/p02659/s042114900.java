import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * ((scanner.nextDouble() + 0.001) * 100.0).longValue() / 100L);
    }
}