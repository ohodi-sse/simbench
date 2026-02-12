import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static long toLong(final double n) {
        return (long)(n * 100.0 + 0.001);
    }
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        System.out.println(Math.floorDiv(nextLong * (long)(nextDouble * 100.0 + 0.001), 100L));
    }
}
