import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static double eps;
    
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (long)((Main.eps + scanner.nextDouble()) * 100.0) / 100L);
    }
    
    static {
        Main.eps = 1.0E-14;
    }
}
