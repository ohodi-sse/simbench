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
        final Integer[] array = new Integer[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int j = -1000; j < 1000; ++j) {
            if (!Arrays.asList(array).contains(j)) {
                min = Math.min(min, Math.abs(nextInt - j));
            }
        }
        final int n = nextInt - min;
        if (Arrays.asList(array).contains(n)) {
            System.out.println(nextInt + min);
            return;
        }
        System.out.println(n);
    }
}
