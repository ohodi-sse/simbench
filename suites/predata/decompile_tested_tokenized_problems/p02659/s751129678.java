import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static final int MOD = 1000000007;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(Long.parseLong(scanner.next())).multiply(new BigDecimal(scanner.next())).setScale(0, RoundingMode.DOWN));
    }
}
