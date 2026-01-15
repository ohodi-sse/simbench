import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(BigDecimal.valueOf(scanner.nextLong()).multiply(BigDecimal.valueOf(scanner.nextDouble())).setScale(0, 1));
    }
}
