import java.math.BigDecimal;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = new Scanner(System.in).nextLine().split(" ");
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).longValue());
    }
}