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
            int n = 0;
            for (int i = 0; i < next.length(); ++i) {
                if (next.charAt(i) == 'R') {
                    ++n;
                }
                else {
                    max = Math.max(max, n);
                    n = 0;
                }
            }
            System.out.println(Math.max(max, n));
        }
    }
}
