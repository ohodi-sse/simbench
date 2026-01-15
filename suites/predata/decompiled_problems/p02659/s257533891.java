import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(Long.toString(scanner.nextLong())).multiply(new BigDecimal(Double.toString(scanner.nextDouble()))).setScale(0, 1));
    }
}
