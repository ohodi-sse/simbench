import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final BigDecimal nextBigDecimal = (scanner = new Scanner(System.in)).nextBigDecimal();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        System.out.println(nextBigDecimal.multiply(BigDecimal.valueOf(nextDouble)).longValue());
    }
}
