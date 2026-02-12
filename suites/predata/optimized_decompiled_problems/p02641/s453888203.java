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
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        Arrays.sort(a);
        int n;
        for (n = 0; a[n] < nextInt; ++n) {}
        int n2 = 0;
        boolean b = true;
        int n3;
        for (n3 = 0; n3 <= nextInt + 100 && nextInt - n3 == a[Math.max(0, n - n2)]; ++n2, ++n3) {
            if (nextInt + n3 != a[Math.min(nextInt2 - 1, n + n2)]) {
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println(nextInt - n3);
            return;
        }
        System.out.println(nextInt + n3);
    }
}
