import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] a = new Integer[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        int x = -100;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int j = nextInt - nextInt2; j < nextInt + nextInt2; ++j) {
            if (!Arrays.asList(a).contains(j)) {
                if (Math.abs(nextInt - x) > Math.abs(nextInt - j)) {
                    x = j;
                }
                else if (Math.abs(nextInt - x) < Math.abs(nextInt - j)) {
                    break;
                }
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
