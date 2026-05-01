import java.math.BigDecimal;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        scanner.close();
        prtln(new BigDecimal(nextLong).multiply(new BigDecimal(next)).toBigInteger());
    }
    
    public static <T> void prtln(final T x) {
        System.out.println(x);
    }
}