import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.nextLong()).multiply(new BigDecimal(Long.valueOf(scanner.next().replace(".", "")))).divide(new BigDecimal(100)).longValue());
    }
}