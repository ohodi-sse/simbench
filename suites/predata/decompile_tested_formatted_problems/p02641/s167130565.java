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
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[101];
        final int[] array4 = new int[101];
        final int[] array5 = new int[nextInt2];
        final int[] array6 = new int[nextInt2];
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j < 101; ++j) {
            array3[j] = nextInt + j;
            array4[j] = nextInt - j;
            for (int k = 0; k < nextInt2; ++k) {
                array5[k] = array3[j] - array2[k];
                array6[k] = array4[j] - array2[k];
                if (array5[k] == 0) {
                    n = n;
                }
                else {
                    ++n;
                }
                if (array6[k] == 0) {
                    n2 = n2;
                }
                else {
                    ++n2;
                }
            }
            if (n == nextInt2 && n2 == nextInt2) {
                System.out.println(Math.min(array3[j], array4[j]));
                break;
            }
            if (n == nextInt2 && n2 != nextInt2) {
                System.out.println(array3[j]);
                break;
            }
            if (n2 == nextInt2 && n != nextInt2) {
                System.out.println(array4[j]);
                break;
            }
            n = 0;
            n2 = 0;
        }
    }
}
