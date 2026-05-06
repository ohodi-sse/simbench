import java.util.Arrays;
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
        final Integer[] a = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        int n = nextInt;
        for (int j = 0; j <= 200; ++j) {
            if (j % 2 == 1) {
                n -= j;
            }
            else {
                n += j;
            }
            if (Arrays.asList(a).indexOf(n) == -1) {
                System.out.println(n);
                return;
            }
        }
    }
}
