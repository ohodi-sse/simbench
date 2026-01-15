import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final HashSet set = new HashSet();
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] a = new int[nextInt2];
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
