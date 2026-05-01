import java.math.BigDecimal;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final BigDecimal nextBigDecimal = scanner.nextBigDecimal();
        final BigDecimal nextBigDecimal2 = scanner.nextBigDecimal();
        scanner.close();
        System.out.println(nextBigDecimal.multiply(nextBigDecimal2).setScale(0, 1).toPlainString());
    }
}