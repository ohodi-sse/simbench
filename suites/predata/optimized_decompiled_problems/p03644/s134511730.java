import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt;
        if ((nextInt = (scanner = new Scanner(System.in)).nextInt()) == 1) {
            System.out.println("1");
            scanner.close();
            return;
        }
        int i;
        for (i = 1; i < nextInt; i <<= 1) {}
        int j;
        int n;
        for (j = i / 2, n = 1; j <= nextInt; j *= n, ++n) {}
        System.out.println(j / --n);
        scanner.close();
    }
}
