import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final boolean[] array = new boolean[201];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = true;
        }
        int min = 500;
        int n = 500;
        for (int j = 0; j <= 200; ++j) {
            if (!array[j]) {
                final int abs;
                if ((abs = Math.abs(nextInt - j)) < n) {
                    min = j;
                    n = abs;
                }
                else if (abs == n) {
                    min = Math.min(min, j);
                }
            }
        }
        System.out.println(min);
    }
}
