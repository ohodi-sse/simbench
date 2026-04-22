import java.math.BigDecimal;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final BigDecimal nextBigDecimal = scanner.nextBigDecimal();
        final BigDecimal nextBigDecimal2 = scanner.nextBigDecimal();
        scanner.close();
        System.out.println(nextBigDecimal.multiply(nextBigDecimal2).toBigInteger());
    }
}