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
        for (int j = 0; j <= 100; ++j) {
            final int x = nextInt - j;
            final int x2 = nextInt + j;
            int n = 0;
            int n2 = 0;
            for (int k = 0; k < nextInt2; ++k) {
                if (array[k] == x) {
                    ++n;
                }
                if (array[k] == x2) {
                    ++n2;
                }
            }
            if (n == 0) {
                System.out.println(x);
                return;
            }
            if (n2 == 0) {
                System.out.println(x2);
                return;
            }
        }
    }
}
