import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            int n = 1;
            for (int i = 0; i <= 100; ++i) {
                if (n > nextInt) {
                    System.out.println(n / 2);
                    break;
                }
                n <<= 1;
            }
        }
    }
    
    private static void solve(final Scanner scanner) {
        final int nextInt = scanner.nextInt();
        int n = 1;
        for (int i = 0; i <= 100; ++i) {
            if (n > nextInt) {
                System.out.println(n / 2);
                return;
            }
            n <<= 1;
        }
    }
}
