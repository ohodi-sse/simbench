import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] a = new Integer[nextInt2 = scanner.nextInt()];
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
