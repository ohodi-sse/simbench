import java.math.BigDecimal;
import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final BigDecimal nextBigDecimal = scanner.nextBigDecimal();
        final BigDecimal nextBigDecimal2 = scanner.nextBigDecimal();
        final BigDecimal bigDecimal = new BigDecimal("1");
        System.out.println(nextBigDecimal.multiply(nextBigDecimal2).setScale(0, 1));
    }
}