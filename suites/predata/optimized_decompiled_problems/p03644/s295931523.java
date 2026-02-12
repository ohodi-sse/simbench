import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int i = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        int n;
        for (n = 1; i >= n; n <<= 1) {}
        System.out.println(n / 2);
    }
}
