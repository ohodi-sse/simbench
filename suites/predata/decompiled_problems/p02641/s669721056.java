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
        final int[] a = new int[nextInt2];
        final int[] array2 = new int[nextInt2];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int x = 0;
        int x2 = 0;
        for (int j = nextInt; j <= 101; ++j) {
            int n = 0;
            for (int k = 0; k < nextInt2; ++k) {
                if (a[k] != j) {
                    ++n;
                }
                else if (a[k] == j) {
                    break;
                }
            }
            if (n == a.length) {
                x = j;
                break;
            }
        }
        for (int l = nextInt; l >= 0; --l) {
            int n2 = 0;
            for (int n3 = 0; n3 < nextInt2; ++n3) {
                if (a[n3] != l) {
                    ++n2;
                }
                else if (a[n3] == l) {
                    break;
                }
            }
            if (n2 == a.length) {
                x2 = l;
                break;
            }
        }
        if (Math.abs(nextInt - x) < Math.abs(nextInt - x2)) {
            System.out.println(x);
        }
        else {
            System.out.println(x2);
        }
    }
}
