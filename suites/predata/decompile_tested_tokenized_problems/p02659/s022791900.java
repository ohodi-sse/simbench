import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        abc169_c();
    }
    
    public static void abc169_c() {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(new BigDecimal(scanner.next()).multiply(new BigDecimal(scanner.next())).setScale(0, RoundingMode.DOWN));
        }
        catch (final Exception obj) {
            System.out.println("\u30a8\u30e9\u30fc" + String.valueOf(obj));
        }
    }
}
