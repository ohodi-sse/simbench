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
        int x = 0;
        int n = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 1; j <= 101; ++j) {
            int n2 = j - nextInt;
            if (n2 < 0) {
                n2 = -n2;
            }
            if (n > n2) {
                boolean b = false;
                for (int k = 0; k < nextInt2; ++k) {
                    if (j == array2[k]) {
                        b = true;
                    }
                }
                if (!b) {
                    x = j;
                    n = n2;
                }
            }
        }
        System.out.println(x);
    }
}
