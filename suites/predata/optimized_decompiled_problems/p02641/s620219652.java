import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final int n = nextInt;
        int x = nextInt;
        int x2 = nextInt;
        int n2 = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < nextInt2 + 1; ++j) {
            for (int k = 0; k < nextInt2; ++k) {
                if (array[k] != nextInt) {
                    ++n2;
                }
            }
            if (n2 == nextInt2) {
                x = nextInt;
                break;
            }
            n2 = 0;
            --nextInt;
        }
        int n3 = n;
        int n4 = 0;
        for (int l = 0; l < nextInt2 + 1; ++l) {
            for (int n5 = 0; n5 < nextInt2; ++n5) {
                if (array[n5] != n3) {
                    ++n4;
                }
            }
            if (n4 == nextInt2) {
                x2 = n3;
                break;
            }
            n4 = 0;
            ++n3;
        }
        if (n - x <= x2 - n) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}
