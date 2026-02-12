import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        Scanner scanner;
        int i;
        int n;
        for (i = (scanner = new Scanner(System.in)).nextInt(), n = 0; i != 1; i /= 2, ++n) {}
        System.out.println((int)Math.pow(2.0, n));
        scanner.close();
    }
}
