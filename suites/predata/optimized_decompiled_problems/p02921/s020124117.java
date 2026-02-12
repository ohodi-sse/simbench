import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String next = scanner.next();
            final String next2 = scanner.next();
            int x = 0;
            for (int i = 0; i < next.length(); ++i) {
                if (next.charAt(i) == next2.charAt(i)) {
                    ++x;
                }
            }
            System.out.println(x);
        }
    }
}
