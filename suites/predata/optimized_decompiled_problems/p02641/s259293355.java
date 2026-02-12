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
        int n2 = 1;
        int n3 = 1;
        int n4 = 1;
        final int[] array = new int[nextInt2];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < array.length; ++i) {
            if ((array[i] = scanner.nextInt()) == nextInt) {
                ++n;
            }
        }
        if (n == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        while (true) {
            final int x = nextInt - n2;
            final int x2 = nextInt + n2;
            for (int j = 0; j < array.length; ++j) {
                if (x == array[j]) {
                    n3 = 0;
                }
                if (x2 == array[j]) {
                    n4 = 0;
                }
            }
            if (n3 == 1) {
                System.out.println(x);
                return;
            }
            if (n4 == 1) {
                System.out.println(x2);
                return;
            }
            ++n2;
            n3 = 1;
            n4 = 1;
        }
    }
}
