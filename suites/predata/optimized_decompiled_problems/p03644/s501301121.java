import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int i = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        System.out.println(1 << n);
    }
}
