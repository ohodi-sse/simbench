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
        int x = 0;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final int[] array2 = new int[nextInt2];
            for (int i = 0; i < nextInt2; ++i) {
                array2[i] = scanner.nextInt();
            }
            int abs = 100;
            for (int j = 0; j <= 101; ++j) {
                boolean b = false;
                for (int k = 0; k < nextInt2; ++k) {
                    if (j == array2[k]) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    if (Math.abs(nextInt - j) < abs) {
                        abs = Math.abs(nextInt - j);
                        x = j;
                    }
                }
            }
            System.out.println(x);
        }
    }
}
