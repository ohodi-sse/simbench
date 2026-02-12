import java.math.RoundingMode;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).setScale(0, RoundingMode.DOWN));
    }
}
