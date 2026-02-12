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
        int x = nextInt;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j <= 100; ++j) {
            boolean b = true;
            for (int k = 0; k < nextInt2; ++k) {
                if (x == array[k]) {
                    b = false;
                }
            }
            if (b) {
                System.out.println(x);
                System.exit(0);
            }
            if (j % 2 == 0) {
                x -= j + 1;
            }
            else {
                x += j + 1;
            }
        }
    }
}
