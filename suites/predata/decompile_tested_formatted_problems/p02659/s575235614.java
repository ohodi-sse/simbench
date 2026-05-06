import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.nextBigDecimal().multiply(new BigDecimal((int)(scanner.nextDouble() * 100.0 + 0.5))).divide(BigDecimal.valueOf(100L)).setScale(0, 1));
    }
}
