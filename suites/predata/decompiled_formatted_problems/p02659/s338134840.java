import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).longValue());
        }
    }
}