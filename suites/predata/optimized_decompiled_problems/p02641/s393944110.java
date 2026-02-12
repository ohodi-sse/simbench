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
        for (int i = 0; i < array2.length; ++i) {
            final int[] array3 = array2;
            final int n = i;
            array3[n] = n;
        }
        for (int j = 0; j < array.length; ++j) {
            array2[array[j] = scanner.nextInt()] = -1;
        }
        int abs = 9999;
        int x = 0;
        if (nextInt2 == 0) {
            x = nextInt;
        }
        for (int k = 0; k < 102; ++k) {
            if (array2[k] != -1 && Math.abs(nextInt - k) < abs) {
                x = k;
                abs = Math.abs(nextInt - k);
            }
        }
        System.out.println(x);
    }
}
