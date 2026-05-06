import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[301];
        for (int i = 0; i < 301; ++i) {
            array2[i] = -100 + i;
        }
        final int[] array3 = new int[nextInt2];
        for (int j = 0; j < nextInt2; ++j) {
            array3[j] = scanner.nextInt();
            array2[100 + array3[j]] = -101;
        }
        int n = 1000;
        int x = 1000;
        for (int k = 0; k < 301; ++k) {
            final int abs = Math.abs(nextInt - array2[k]);
            if (abs < n) {
                n = abs;
                x = array2[k];
            }
        }
        System.out.println(x);
    }
}
