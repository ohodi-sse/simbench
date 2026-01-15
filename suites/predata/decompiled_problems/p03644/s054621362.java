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
            array2[i] = 0;
            int[] array3;
            int n3;
            for (int n = i, n2 = 0; n % 2 == 0; n /= 2, array3 = array2, n3 = i, ++array3[n3], ++n2) {}
        }
        int x = 1;
        int n4 = array2[1];
        for (int j = 2; j < nextInt + 1; ++j) {
            if (n4 < array2[j]) {
                x = j;
                n4 = array2[j];
            }
        }
        System.out.println(x);
    }
}
