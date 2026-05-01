import java.math.BigInteger;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(BigInteger.valueOf(Long.parseLong(scanner.next())).multiply(BigInteger.valueOf(Long.parseLong(scanner.next().replace(".", "")))).divide(BigInteger.valueOf(100L)).longValue());
    }
}