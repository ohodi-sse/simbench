import java.math.BigDecimal;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long long1 = Long.parseLong(scanner.next());
        final double double1 = Double.parseDouble(scanner.next());
        scanner.close();
        System.out.println(BigDecimal.valueOf(long1).multiply(BigDecimal.valueOf(double1)).setScale(0, 1).toString());
    }
}