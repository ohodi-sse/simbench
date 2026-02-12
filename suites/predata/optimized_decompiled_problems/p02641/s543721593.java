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
        final int[] array2 = new int[102];
        for (int i = 0; i <= 101; ++i) {
            final int[] array3 = array2;
            final int n = i;
            array3[n] = n;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array2[array[j] = scanner.nextInt()] = -1;
        }
        int abs = 99999;
        int k = 0;
        if (nextInt2 == 0) {
            k = nextInt;
        }
        for (int l = 0; l <= 101; ++l) {
            if (array2[l] != -1 && Math.abs(l - nextInt) < abs) {
                k = l;
                abs = Math.abs(l - nextInt);
            }
        }
        System.out.print(k);
    }
}
