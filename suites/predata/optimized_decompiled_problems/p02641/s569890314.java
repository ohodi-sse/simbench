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
        int n;
        for (n = 0; Arrays.asList(a).contains(nextInt - n) && Arrays.asList(a).contains(nextInt + n); ++n) {}
        if (Arrays.asList(a).contains(nextInt - n)) {
            System.out.println(nextInt + n);
            return;
        }
        System.out.println(nextInt - n);
    }
}
