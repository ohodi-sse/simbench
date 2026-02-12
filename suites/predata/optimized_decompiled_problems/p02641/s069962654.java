import java.util.Arrays;
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
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        final int[] array = new int[102];
        Arrays.sort(a);
        int n = 0;
        for (int j = 0; j <= 101; ++j) {
            if (n < nextInt2) {
                if (a[n] == j) {
                    ++n;
                }
                else {
                    final int[] array2 = array;
                    final int n2 = j;
                    array2[n2] = n2;
                }
            }
            else {
                final int[] array3 = array;
                final int n3 = j;
                array3[n3] = n3;
            }
        }
        int x = 0;
        int n4 = 200;
        for (int k = 0; k <= 101; ++k) {
            int n5;
            if ((n5 = nextInt - array[k]) < 0) {
                n5 = -n5;
            }
            if (n4 > n5) {
                n4 = n5;
                x = array[k];
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
