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
        int x = nextInt;
        int x2 = nextInt;
        int n = nextInt;
        while (true) {
            for (int j = 0; j < nextInt2; ++j) {
                if (n == array[j]) {
                    x = 200;
                    break;
                }
                x = n;
            }
            if (x == n) {
                break;
            }
            --n;
        }
        int n2 = nextInt;
        while (true) {
            for (int k = 0; k < nextInt2; ++k) {
                if (n2 == array[k]) {
                    x2 = 200;
                    break;
                }
                x2 = n2;
            }
            if (x2 == n2) {
                break;
            }
            ++n2;
        }
        if (nextInt - x > x2 - nextInt) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}
