import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        Scanner scanner;
        int nextInt;
        int n;
        for (nextInt = (scanner = new Scanner(System.in)).nextInt(), n = 0; (int)Math.pow(2.0, n) <= nextInt; ++n) {}
        System.out.println((int)Math.pow(2.0, n - 1));
        scanner.close();
    }
}
