import java.math.BigDecimal;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(new BigDecimal(scanner.next()).multiply(new BigDecimal(scanner.next())).longValue());
        }
    }
}