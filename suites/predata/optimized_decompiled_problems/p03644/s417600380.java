import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        new Main();
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int x = 0;
        if (nextInt == 0) {
            System.out.println("0");
        }
        else {
            for (int i = 0; i < 7; ++i) {
                x = (int)Math.pow(2.0, i);
                if (nextInt / x == 1) {
                    break;
                }
            }
            System.out.println(x);
        }
        scanner.close();
    }
    
    private static void solve(final Scanner scanner) {
        final int nextInt = scanner.nextInt();
        int x = 0;
        if (nextInt == 0) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < 7; ++i) {
            x = (int)Math.pow(2.0, i);
            if (nextInt / x == 1) {
                break;
            }
        }
        System.out.println(x);
    }
}
