import java.util.Arrays;
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
        final int[] array2 = new int[nextInt2 + 10];
        final int[] a = new int[200];
        final int[] a2 = new int[200];
        Arrays.fill(a, 0);
        Arrays.fill(a2, 0);
        a2[0] = 1;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            final int n = array2[i] - nextInt;
            if (n >= 0) {
                a[n] = 1;
            }
            else {
                a2[n * -1] = 1;
            }
        }
        int n2 = 0;
        for (int j = 0; j < 100; ++j) {
            if (a2[j] == 0) {
                n2 = -j;
                break;
            }
            if (a[j] == 0) {
                n2 = j;
                break;
            }
            if (j == nextInt) {
                break;
            }
        }
        System.out.println(nextInt + n2);
    }
}
