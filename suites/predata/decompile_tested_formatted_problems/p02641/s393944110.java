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
        final int[] array3 = new int[102];
        for (int i = 0; i < array3.length; ++i) {
            array3[i] = i;
        }
        for (int j = 0; j < array2.length; ++j) {
            array3[array2[j] = scanner.nextInt()] = -1;
        }
        int abs = 9999;
        int x = 0;
        if (nextInt2 == 0) {
            x = nextInt;
        }
        for (int k = 0; k < 102; ++k) {
            if (array3[k] != -1 && Math.abs(nextInt - k) < abs) {
                x = k;
                abs = Math.abs(nextInt - k);
            }
        }
        System.out.println(x);
    }
}
