import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        final int[] array = new int[(nextInt = new Scanner(System.in).nextInt()) + 1];
        for (int i = 1; i <= nextInt; ++i) {
            final int[] array2 = array;
            final int n = i;
            array2[n] = n;
        }
        int x = 1;
        int j;
        do {
            j = 0;
            for (int k = 1; k <= nextInt; ++k) {
                if (array[k] % 2 == 0) {
                    array[k] /= 2;
                    x = k;
                }
                else {
                    ++j;
                }
            }
        } while (j != nextInt);
        System.out.println(x);
    }
}
