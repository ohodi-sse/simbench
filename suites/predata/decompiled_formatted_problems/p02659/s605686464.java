import java.util.Scanner;
import java.math.BigDecimal;





public class Main
{
    public static String solve(final BigDecimal bigDecimal, final BigDecimal multiplicand) {
        final String string = bigDecimal.multiply(multiplicand).toString();
        final int index = string.indexOf(46);
        return (index == -1) ? string : string.substring(0, index);
    }
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(solve(new BigDecimal(scanner.next()), new BigDecimal(scanner.next())));
    }
}