import java.util.Scanner;
import java.math.BigDecimal;

public class Main
{
    public static String mul(final String val, final String val2, final int newScale) {
        if (newScale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        return new BigDecimal(val).multiply(new BigDecimal(val2)).setScale(newScale, 1).toString();
    }
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final Main main = new Main();
        System.out.println(mul(next, next2, 0));
    }
}