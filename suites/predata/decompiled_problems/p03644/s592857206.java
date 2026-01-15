import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = new int[nextInt + 1];
        for (int i = 1; i <= nextInt; ++i) {
            array2[i] = i;
        }
        int x = 1;
        int n;
        do {
            n = 0;
            for (int j = 1; j <= nextInt; ++j) {
                if (array2[j] % 2 == 0) {
                    array2[j] /= 2;
                    x = j;
                }
                else {
                    ++n;
                }
            }
        } while (n != nextInt);
        System.out.println(x);
    }
}
