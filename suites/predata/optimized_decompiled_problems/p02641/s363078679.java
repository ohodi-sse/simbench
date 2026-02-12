import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int int1 = Integer.parseInt(scanner.next());
            final int int2 = Integer.parseInt(scanner.next());
            final boolean[] array = new boolean[102];
            for (int i = 0; i < int2; ++i) {
                array[Integer.parseInt(scanner.next())] = true;
            }
            for (int j = 0; j <= 50; ++j) {
                if (int1 - j >= 0 && !array[int1 - j]) {
                    System.out.println(int1 - j);
                    scanner.close();
                    return;
                }
                if (int1 + j <= 101 && !array[int1 + j]) {
                    System.out.println(int1 + j);
                    scanner.close();
                    return;
                }
            }
        }
    }
}
