import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        for (int j = 0; j <= 100; ++j) {
            int n = 1;
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - j == array[k]) {
                    n = 0;
                }
            }
            if (n == 1) {
                System.out.println(nextInt - j);
                System.exit(0);
            }
            int n2 = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (nextInt + j == array[l]) {
                    n2 = 0;
                }
            }
            if (n2 == 1) {
                System.out.println(nextInt + j);
                System.exit(0);
            }
        }
    }
}
