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
        final int[] array = new int[301];
        for (int i = 0; i < 301; ++i) {
            final int[] array2 = array;
            final int n = i;
            array2[n] = n - 100;
        }
        final int[] array3 = new int[nextInt2];
        for (int j = 0; j < nextInt2; ++j) {
            array3[j] = scanner.nextInt();
            array[100 + array3[j]] = -101;
        }
        int n2 = 1000;
        int x = 1000;
        for (int k = 0; k < 301; ++k) {
            final int abs;
            if ((abs = Math.abs(nextInt - array[k])) < n2) {
                n2 = abs;
                x = array[k];
            }
        }
        System.out.println(x);
    }
}
