import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int nextInt = scanner.nextInt();
            int n = 0;
            int x = 0;
            for (int i = 1; i <= nextInt; ++i) {
                final int n2 = i;
                int n3 = 0;
                for (int n4 = n2; n4 % 2 != 1; n4 /= 2, ++n3) {}
                final int n5 = n3;
                if (n <= n5) {
                    x = i;
                    n = n5;
                }
            }
            System.out.println(x);
        }
    }
    
    private static int returnEvenCnt(int n, int n2) {
        while (n % 2 != 1) {
            n /= 2;
            ++n2;
        }
        return n2;
    }
}
