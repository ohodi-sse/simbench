import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int max = 0;
        int b = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'S') {
                b = 0;
            }
            else {
                ++b;
                max = Math.max(max, b);
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
