import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(BigDecimal.valueOf(scanner.nextDouble()).multiply(BigDecimal.valueOf(scanner.nextDouble())).longValue());
    }
}