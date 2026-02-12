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
        int x = 0;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int abs = 100;
        for (int j = 0; j <= 101; ++j) {
            boolean b = false;
            for (int k = 0; k < nextInt2; ++k) {
                if (j == array[k]) {
                    b = true;
                    break;
                }
            }
            if (!b && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}
