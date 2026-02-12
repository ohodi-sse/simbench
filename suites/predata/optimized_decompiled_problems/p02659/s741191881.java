import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long x = (scanner = new Scanner(System.in)).nextLong() * (long)(scanner.nextDouble() * 100.0 + 0.001) / 100L;
        scanner.close();
        System.out.println(x);
    }
}
