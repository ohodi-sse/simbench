import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String plainString = new BigDecimal(String.valueOf((scanner = new Scanner(System.in)).next())).multiply(new BigDecimal(String.valueOf(scanner.next()))).setScale(0, RoundingMode.DOWN).toPlainString();
        scanner.close();
        System.out.println(plainString);
    }
}
