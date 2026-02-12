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
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array = new int[nextInt2];
        for (int i = 0; i < array.length; ++i) {
            array[i] = scanner.nextInt();
        }
        do {
            for (int j = 0; j < array.length; ++j) {
                if (array[j] == nextInt + n3) {
                    ++n3;
                }
            }
        } while (++n <= n3);
        do {
            for (int k = 0; k < array.length; ++k) {
                if (array[k] == nextInt + n4) {
                    --n4;
                }
            }
        } while (--n2 >= n4);
        final int n5;
        if ((n5 = n3 + n4) >= 0) {
            System.out.println(nextInt + n4);
            return;
        }
        if (n5 < 0) {
            System.out.println(nextInt + n3);
        }
    }
}
