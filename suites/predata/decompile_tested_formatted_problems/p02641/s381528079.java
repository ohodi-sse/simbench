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
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j < 100; ++j) {
            boolean b = false;
            for (int k = 0; k < nextInt2; ++k) {
                if (array2[k] == nextInt - j) {
                    b = true;
                }
            }
            if (!b) {
                x = nextInt - j;
                break;
            }
            boolean b2 = false;
            for (int l = 0; l < nextInt2; ++l) {
                if (array2[l] == nextInt + j) {
                    b2 = true;
                }
            }
            if (!b2) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
}
