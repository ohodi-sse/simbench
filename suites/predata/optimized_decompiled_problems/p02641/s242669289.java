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
        final int n = nextInt;
        int n2 = 0;
        int x;
        while (true) {
            final int n3 = n - n2;
            boolean b = false;
            for (int j = 0; j < nextInt2; ++j) {
                if (n3 == array[j]) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                x = n3;
                break;
            }
            final int n4 = n + n2;
            boolean b2 = false;
            for (int k = 0; k < nextInt2; ++k) {
                if (n4 == array[k]) {
                    b2 = true;
                    break;
                }
            }
            if (!b2) {
                x = n4;
                break;
            }
            ++n2;
        }
        System.out.println(x);
    }
}
