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
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array2 = new int[nextInt2];
        scanner.nextLine();
        int abs = 100;
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        int n = 0;
        for (int j = -101; j < 201; ++j) {
            for (int k = 0; k < nextInt2; ++k) {
                if (array2[k] == j) {
                    n = 1;
                    break;
                }
            }
            if (n == 0) {
                if (Math.abs(j - nextInt) < abs) {
                    abs = Math.abs(j - nextInt);
                    x = j;
                }
            }
            else {
                n = 0;
            }
        }
        scanner.close();
        System.out.println(x);
    }
}
