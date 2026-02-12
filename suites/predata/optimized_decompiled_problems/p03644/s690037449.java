import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        int i;
        int n;
        for (i = 0, n = 0; i <= nextInt; i = (int)Math.pow(2.0, n)) {
            ++n;
        }
        System.out.println((int)Math.pow(2.0, n - 1));
    }
}
