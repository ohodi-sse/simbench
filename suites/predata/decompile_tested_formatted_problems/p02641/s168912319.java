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
        int x = nextInt;
        int n = 1;
        int i = 1;
        for (int j = 0; j < nextInt2; ++j) {
            array2[j] = scanner.nextInt();
        }
        for (int k = 0; k < nextInt2; ++k) {
            if (array2[k] == nextInt) {
                i = 0;
                break;
            }
        }
        while (i == 0) {
            int n2 = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if (array2[l] == nextInt - n) {
                    n2 = 0;
                    break;
                }
            }
            if (n2 == 1) {
                x = nextInt - n;
                break;
            }
            i = 1;
            for (int n3 = 0; n3 < nextInt2; ++n3) {
                if (array2[n3] == nextInt + n) {
                    i = 0;
                    break;
                }
            }
            if (i == 1) {
                x = nextInt + n;
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}
