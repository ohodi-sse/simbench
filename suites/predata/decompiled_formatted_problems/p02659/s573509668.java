import java.math.RoundingMode;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).setScale(0, RoundingMode.DOWN));
    }
}