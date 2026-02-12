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
        int x = 110;
        final int[] array = new int[110];
        if (nextInt2 != 0) {
            for (int i = 0; i < nextInt2; ++i) {
                final int nextInt3 = scanner.nextInt();
                final int[] array2 = array;
                final int n = nextInt3;
                array2[n] = n;
            }
            int n2 = 110;
            for (int j = 0; j <= 101; ++j) {
                final int abs = Math.abs(nextInt - j);
                if (array[j] == 0 && abs < n2) {
                    n2 = abs;
                    x = j;
                }
            }
        }
        else {
            x = nextInt;
        }
        System.out.println(x);
    }
}
