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
        final boolean[] array3 = new boolean[102];
        for (int i = 0; i < nextInt2; ++i) {
            array3[array2[i] = scanner.nextInt()] = true;
        }
        for (int j = 0; j < nextInt + 1; ++j) {
            if (!array3[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (!array3[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
        int x;
        if (nextInt > 50) {
            x = 101;
        }
        else {
            x = -1;
        }
        System.out.println(x);
    }
}
