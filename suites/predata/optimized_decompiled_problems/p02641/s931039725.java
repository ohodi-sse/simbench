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
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int x = -100000000;
        int n = 0;
        int n2 = -1000000000;
        int j = 0;
        while (j < 1000) {
            for (int k = 0; k < nextInt2; ++k) {
                if (nextInt - j == a[k]) {
                    ++n;
                    n2 = a[k];
                }
                else if (nextInt + j == a[k]) {
                    ++n;
                    n2 = a[k];
                }
            }
            if (n == 1 && j != 0) {
                if (n2 == nextInt - j) {
                    x = nextInt + j;
                    break;
                }
                if (n2 == nextInt + j) {
                    x = nextInt - j;
                    break;
                }
                break;
            }
            else {
                if (n == 0) {
                    x = nextInt - j;
                    break;
                }
                n = 0;
                ++j;
            }
        }
        System.out.println(x);
    }
}
