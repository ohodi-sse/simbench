import java.util.Collections;
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
        final int nextInt2 = scanner.nextInt();
        int x = nextInt;
        int x2 = nextInt;
        final Integer[] array = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (final int intValue : array) {
            if (x == intValue) {
                x = intValue + 1;
            }
        }
        Arrays.sort(array, Collections.reverseOrder());
        for (final int intValue2 : array) {
            if (x2 == intValue2) {
                x2 = intValue2 - 1;
            }
        }
        if (Math.abs(x - nextInt) < Math.abs(x2 - nextInt)) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}
