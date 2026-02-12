import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int max = 100;
    
    private static void main$3231c38a() {
        final Scanner scanner;
        System.out.println((scanner = new Scanner(System.in)).nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
        scanner.close();
    }
    
    private static void cal(final long n, final double n2) {
        System.out.println(n * Math.round(n2 * 100.0) / 100L);
    }
}
