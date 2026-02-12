import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final double nextDouble;
        if ((nextDouble = scanner.nextDouble()) == 0.0) {
            System.out.println(0);
            scanner.close();
            return;
        }
        System.out.println(Math.floorDiv(nextLong * Math.round(nextDouble * 100.0), 100));
        scanner.close();
    }
}
