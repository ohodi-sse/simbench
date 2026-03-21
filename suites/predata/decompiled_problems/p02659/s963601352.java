import java.math.BigDecimal;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(BigDecimal.valueOf(scanner.nextDouble()).multiply(BigDecimal.valueOf(scanner.nextDouble())).setScale(0, 1));
    }
}