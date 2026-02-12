import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        System.out.println(new BigDecimal((scanner = new Scanner(System.in)).next()).multiply(new BigDecimal(scanner.next())).longValue());
        scanner.close();
    }
}
