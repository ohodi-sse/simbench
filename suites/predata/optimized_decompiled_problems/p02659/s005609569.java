import java.math.BigDecimal;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final BigDecimal nextBigDecimal = (scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextBigDecimal();
        final BigDecimal nextBigDecimal2 = scanner.nextBigDecimal();
        scanner.close();
        System.out.println(nextBigDecimal.multiply(nextBigDecimal2).toBigInteger());
    }
}
