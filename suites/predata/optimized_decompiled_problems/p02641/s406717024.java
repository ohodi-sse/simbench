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
        final int[] array = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 1;
        }
        if (array[nextInt] == 0) {
            System.out.println(nextInt);
            return;
        }
        int n = nextInt - 1;
        int n2 = nextInt + 1;
        int x = Integer.MAX_VALUE;
        while (n >= 0 && n2 < array.length) {
            if (array[n] == 0) {
                x = n;
                break;
            }
            --n;
            if (array[n2] == 0) {
                x = n2;
                break;
            }
            ++n2;
        }
        while (n < 0 && n2 < array.length) {
            if (array[n2] == 0) {
                x = n2;
                break;
            }
            ++n2;
        }
        while (n2 >= array.length && n >= 0) {
            if (array[n] == 0) {
                x = n;
                break;
            }
            --n;
        }
        System.out.println(x);
    }
}
