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
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[100];
        int n = 0;
        array3[0] = 1;
        for (int i = 1; i < 100; ++i) {
            array3[i] = 2;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array[j] = scanner.nextInt();
            array3[array2[j] = Math.abs(array[j] - nextInt)] = array3[array2[j]] - 1;
        }
        for (int k = 0; k < 100; ++k) {
            if (array3[k] == 2) {
                System.out.println(nextInt - k);
                System.exit(0);
            }
            if (array3[k] == 1) {
                for (int l = 0; l < nextInt2; ++l) {
                    if (array[l] == nextInt + k) {
                        ++n;
                    }
                }
                if (n == 0) {
                    System.out.println(nextInt + k);
                    System.exit(0);
                }
                else {
                    System.out.println(nextInt - k);
                    System.exit(0);
                }
            }
        }
    }
}
