import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        new HashSet();
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] a = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int n = 0;
        int j = 0;
        int x = 0;
        while (j == 0) {
            if (Arrays.binarySearch(a, nextInt - n) < 0) {
                x = nextInt - n;
                j = 1;
            }
            else if (Arrays.binarySearch(a, nextInt + n) < 0) {
                x = nextInt + n;
                j = 1;
            }
            ++n;
        }
        System.out.println(x);
    }
}
