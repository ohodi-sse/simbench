import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        scanner.close();
        System.out.println(nextLong * (0 + Integer.parseInt(next.substring(0, 1)) * 100 + Integer.parseInt(next.substring(2, 3)) * 10 + Integer.parseInt(next.substring(3, 4))) / 100L);
    }
}
