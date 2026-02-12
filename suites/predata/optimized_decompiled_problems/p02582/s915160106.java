import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String next = scanner.next();
            int max = 0;
            int b = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == 'R') {
                    ++b;
                }
                max = Math.max(max, b);
                if (next.charAt(i) == 'S') {
                    b = 0;
                }
            }
            System.out.print(max);
        }
    }
}
