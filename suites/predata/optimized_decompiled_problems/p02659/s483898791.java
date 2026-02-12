import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        System.out.println(BigDecimal.valueOf((scanner = new Scanner(System.in)).nextLong()).multiply(BigDecimal.valueOf(scanner.nextDouble())).longValue());
        scanner.close();
    }
}
