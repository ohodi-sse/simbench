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
        for (int j = 0; j <= 100; ++j) {
            final int x = nextInt - j;
            final int x2 = nextInt + j;
            int n = 0;
            int n2 = 0;
            for (int k = 0; k < nextInt2; ++k) {
                if (array2[k] == x) {
                    ++n;
                }
                if (array2[k] == x2) {
                    ++n2;
                }
            }
            if (n == 0) {
                System.out.println(x);
                break;
            }
            if (n2 == 0) {
                System.out.println(x2);
                break;
            }
        }
    }
}
