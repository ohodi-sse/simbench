import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(String.valueOf(new BigDecimal(String.valueOf(scanner.nextDouble())).multiply(new BigDecimal(String.valueOf(scanner.nextDouble()))))).setScale(0, RoundingMode.DOWN));
    }
}