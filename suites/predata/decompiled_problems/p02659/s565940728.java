import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String plainString = new BigDecimal(String.valueOf(scanner.next())).multiply(new BigDecimal(String.valueOf(scanner.next()))).setScale(0, RoundingMode.DOWN).toPlainString();
        scanner.close();
        System.out.println(plainString);
    }
}
