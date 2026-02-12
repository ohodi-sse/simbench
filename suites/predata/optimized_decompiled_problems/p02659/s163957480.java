import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.next()).multiply(new BigDecimal(scanner.next())).setScale(0, 1));
    }
}
