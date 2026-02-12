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
        while (true) {
            int n;
            for (n = 0; Arrays.binarySearch(a, nextInt - n) >= 0; ++n) {
                if (Arrays.binarySearch(a, nextInt + n) < 0) {
                    final int x = nextInt + n;
                    System.out.println(x);
                    return;
                }
            }
            final int x = nextInt - n;
            continue;
        }
    }
}
