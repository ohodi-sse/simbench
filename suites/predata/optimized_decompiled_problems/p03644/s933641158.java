import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        final int[] array = new int[nextInt = new Scanner(System.in).nextInt()];
        for (int i = 1; i <= nextInt; ++i) {
            for (int n = i; i != 0 && n % 2 == 0; n /= 2) {
                final int[] array2 = array;
                final int n2 = i - 1;
                ++array2[n2];
            }
        }
        int n3 = array[0];
        int n4 = 0;
        for (int j = 1; j < nextInt; ++j) {
            if (array[j] > n3) {
                n3 = array[j];
                n4 = j;
            }
        }
        System.out.println(n4 + 1);
    }
}
