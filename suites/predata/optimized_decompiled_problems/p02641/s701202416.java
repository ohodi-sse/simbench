import java.util.HashSet;
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
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int x = -1;
        int abs = 1000;
        final HashSet set = new HashSet();
        for (int j = 0; j < nextInt2; ++j) {
            set.add(array[j]);
        }
        for (int k = -100; k <= 200; ++k) {
            if (!set.contains(k) && Math.abs(k - nextInt) < abs) {
                abs = Math.abs(k - nextInt);
                x = k;
            }
        }
        System.out.println(x);
    }
}
