import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    private static final int MOD = 1000000007;
    private static final String YES = "Yes";
    private static final String NO = "No";
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextLong(), scanner.nextDouble()));
    }
    
    private static String solve(final long val, final double val2) {
        return BigDecimal.valueOf(val).multiply(BigDecimal.valueOf(val2)).setScale(0, RoundingMode.DOWN).toString();
    }
}