import java.math.BigDecimal;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        String x = new BigDecimal(scanner.nextLong()).multiply(new BigDecimal(Long.parseLong(scanner.next().replace(".", ""))).divide(new BigDecimal("100"))).toString();
        if (x.contains(".")) {
            x = x.substring(0, x.indexOf("."));
        }
        System.out.println(x);
    }
}