import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(new BigInteger(scanner.next())).multiply(BigDecimal.valueOf(scanner.nextDouble())).toBigInteger().longValue());
    }
}
