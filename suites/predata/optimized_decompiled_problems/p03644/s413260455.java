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
        int x = 0;
        for (int i = 0; i < nextInt; ++i) {
            if ((x = (int)Math.pow(2.0, i)) > nextInt) {
                x = (int)Math.pow(2.0, i - 1);
                break;
            }
        }
        System.out.println(x);
    }
}
