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
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array = new int[100];
        for (int i = 0; i < 100; ++i) {
            array[i] = 0;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array[scanner.nextInt() - 1] = 1;
        }
        int x = 101;
        for (int k = nextInt - 1; k < 100; ++k) {
            if (array[k] == 0) {
                x = k + 1;
                break;
            }
        }
        int l = nextInt - 1;
        while (l >= 0) {
            if (array[l] == 0) {
                if (Math.abs(nextInt - x) >= Math.abs(nextInt - (l + 1))) {
                    x = l + 1;
                    break;
                }
                break;
            }
            else {
                if (l == 0 && Math.abs(nextInt - x) >= nextInt) {
                    x = 0;
                }
                --l;
            }
        }
        System.out.println(x);
    }
}
