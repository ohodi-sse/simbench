import java.math.RoundingMode;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        System.out.println((scanner = new Scanner(System.in)).nextBigDecimal().multiply(scanner.nextBigDecimal()).setScale(0, RoundingMode.DOWN));
        scanner.close();
    }
}
