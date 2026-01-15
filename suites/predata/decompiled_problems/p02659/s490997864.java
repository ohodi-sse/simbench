import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        System.out.println(new BigDecimal(nextLong).multiply(new BigDecimal((long)(nextDouble * 1000.0))).divideToIntegralValue(new BigDecimal("1000")));
    }
}
