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
        if ((nextInt2 = scanner.nextInt()) <= 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array = new int[102];
        for (int i = 0; i < 102; ++i) {
            array[i] = 0;
        }
        for (int j = 0; j < nextInt2; ++j) {
            final int nextInt3 = scanner.nextInt();
            final int[] array2 = array;
            final int n = nextInt3;
            array2[n] = n;
        }
        int x = nextInt;
        int x2 = nextInt;
        while (array[x] != 0 && array[x2] != 0) {
            ++x;
            --x2;
            if (array[x] == 0 && array[x2] == 0) {
                break;
            }
            if (array[x] == 0) {
                --x2;
            }
            else {
                if (array[x2] != 0) {
                    continue;
                }
                ++x;
            }
        }
        if (nextInt - x2 <= x - nextInt) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}
