import java.util.Scanner;
import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static BigDecimal MAX;
    
    private static void main$3231c38a() {
        final Scanner scanner;
        System.out.println((scanner = new Scanner(System.in)).nextLong() * Long.valueOf(scanner.next().replace(".", "")) / 100L);
        scanner.close();
    }
    
    static {
        new BigDecimal(1000000000000000000L);
    }
}
