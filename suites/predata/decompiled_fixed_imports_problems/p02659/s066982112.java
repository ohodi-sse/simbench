import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        new Main().run();
    }
    
    void run() {
        final Scanner scanner = new Scanner(System.in);
        final BigDecimal bigDecimal = new BigDecimal(scanner.next());
        final BigDecimal bigDecimal2 = new BigDecimal(scanner.next().replace(".", ""));
        final BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        String x = bigDecimal.multiply(bigDecimal2).toPlainString();
        if (multiply.compareTo(new BigDecimal(100)) < 0) {
            x = "0";
        }
        if (2 < x.length()) {
            x = x.substring(0, x.length() - 2);
        }
        System.out.println(x);
    }
}