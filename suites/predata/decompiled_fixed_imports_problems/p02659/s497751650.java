import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Long.parseLong(new BigDecimal(scanner.next()).multiply(new BigDecimal("100.0")).toBigInteger().toString()) / 100L);
    }
}