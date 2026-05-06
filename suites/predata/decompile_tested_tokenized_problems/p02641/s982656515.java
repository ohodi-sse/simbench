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
        int abs = 10000;
        int x = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = 0;
        for (int j = -101; j < 102; ++j) {
            if (n < nextInt2 && a[n] == j) {
                ++n;
            }
            else if (Math.abs(j - nextInt) < abs) {
                abs = Math.abs(j - nextInt);
                x = j;
            }
        }
        System.out.println(x);
    }
}
