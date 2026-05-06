import java.math.RoundingMode;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).setScale(0, RoundingMode.DOWN));
        scanner.close();
    }
}
