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
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        scanner.close();
        for (int j = 0; j <= 100; ++j) {
            int n = 1;
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - j == array2[k]) {
                    n = 0;
                }
            }
            if (n == 1) {
                System.out.println(nextInt - j);
                System.exit(0);
            }
            int n2 = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (nextInt + j == array2[l]) {
                    n2 = 0;
                }
            }
            if (n2 == 1) {
                System.out.println(nextInt + j);
                System.exit(0);
            }
        }
    }
}
