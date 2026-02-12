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
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] a = new int[nextInt2];
        final int[] array;
        (array = new int[102 - nextInt2])[0] = 0;
        array[101 - nextInt2] = 101;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = 0;
        int n2 = 0;
        for (int j = 0; j <= 101; ++j) {
            if (a[n2] != j) {
                array[n] = j;
                ++n;
            }
            else if (++n2 >= nextInt2) {
                --n2;
            }
        }
        int abs = nextInt;
        int x = 0;
        for (int k = 0; k < array.length; ++k) {
            if (abs > Math.abs(array[k] - nextInt)) {
                abs = Math.abs(array[k] - nextInt);
                x = array[k];
            }
        }
        System.out.println(x);
    }
}
