import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Long.parseLong(new BigDecimal(scanner.next()).multiply(new BigDecimal("100.0")).toBigInteger().toString()) / 100L);
    }
}
