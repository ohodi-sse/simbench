import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
        final String string = new BigDecimal(String.valueOf(scanner.nextDouble())).multiply(new BigDecimal(String.valueOf(scanner.nextLong()))).toString();
        System.out.println(string.substring(0, string.indexOf(".")));
    }
}
