import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 1;
        final int[] array = new int[nextInt + 1];
        for (int i = 1; i <= nextInt; ++i) {
            for (int n2 = i; n2 % 2 == 0; n2 /= 2) {
                final int[] array2 = array;
                final int n3 = i;
                ++array2[n3];
            }
            if (array[i] > n) {
                n = array[i];
                x = i;
            }
        }
        System.out.println(x);
    }
}
