import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(new BigDecimal(scanner.next()).multiply(new BigDecimal(scanner.next())).setScale(0, RoundingMode.DOWN));
        }
        catch (final Exception obj) {
            System.out.println("\u30a8\u30e9\u30fc" + String.valueOf(obj));
        }
    }
    
    private static void abc169_c() {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(new BigDecimal(scanner.next()).multiply(new BigDecimal(scanner.next())).setScale(0, RoundingMode.DOWN));
        }
        catch (final Exception obj) {
            System.out.println("\u30a8\u30e9\u30fc" + String.valueOf(obj));
        }
    }
}
