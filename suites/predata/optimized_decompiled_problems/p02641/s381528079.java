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
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < 100; ++j) {
            boolean b = false;
            for (int k = 0; k < nextInt2; ++k) {
                if (array[k] == nextInt - j) {
                    b = true;
                }
            }
            if (!b) {
                x = nextInt - j;
                break;
            }
            boolean b2 = false;
            for (int l = 0; l < nextInt2; ++l) {
                if (array[l] == nextInt + j) {
                    b2 = true;
                }
            }
            if (!b2) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
}
