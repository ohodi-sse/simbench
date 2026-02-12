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
        final int[] array2 = new int[101];
        final int[] array3 = new int[101];
        final int[] array4 = new int[nextInt2];
        final int[] array5 = new int[nextInt2];
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < 101; ++j) {
            array2[j] = nextInt + j;
            array3[j] = nextInt - j;
            for (int k = 0; k < nextInt2; ++k) {
                array4[k] = array2[j] - array[k];
                array5[k] = array3[j] - array[k];
                if (array4[k] != 0) {
                    ++n;
                }
                if (array5[k] != 0) {
                    ++n2;
                }
            }
            if (n == nextInt2 && n2 == nextInt2) {
                System.out.println(Math.min(array2[j], array3[j]));
                return;
            }
            if (n == nextInt2 && n2 != nextInt2) {
                System.out.println(array2[j]);
                return;
            }
            if (n2 == nextInt2 && n != nextInt2) {
                System.out.println(array3[j]);
                return;
            }
            n = 0;
            n2 = 0;
        }
    }
}
