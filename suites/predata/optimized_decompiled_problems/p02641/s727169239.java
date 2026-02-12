import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int indexOf(final int[] array, final int n) {
        int n2 = -1;
        int i = 0;
        int n3 = array.length - 1;
        while (i <= n3) {
            final int n4 = (i + n3) / 2;
            if (array[n4] == n) {
                n2 = n4;
                break;
            }
            if (array[n4] < n) {
                i = n4 + 1;
            }
            else {
                n3 = n4 - 1;
            }
        }
        return n2;
    }
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            scanner.close();
            return;
        }
        final int[] a = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        final int[] array = a;
        final int n = nextInt;
        final int[] array2 = array;
        int n2 = -1;
        int j = 0;
        int n3 = array2.length - 1;
        while (j <= n3) {
            final int n4 = (j + n3) / 2;
            if (array2[n4] == n) {
                n2 = n4;
                break;
            }
            if (array2[n4] < n) {
                j = n4 + 1;
            }
            else {
                n3 = n4 - 1;
            }
        }
        final int n5;
        if ((n5 = n2) != -1) {
            int n6 = 0;
            boolean b;
            int x;
            int x2;
            do {
                ++n6;
                b = false;
                x = Integer.MIN_VALUE;
                x2 = Integer.MAX_VALUE;
                if (n5 - n6 < 0 || a[n5 - n6] != nextInt - n6) {
                    x = nextInt - n6;
                    b = true;
                }
                if (n5 + n6 >= nextInt2 || a[n5 + n6] != nextInt + n6) {
                    x2 = nextInt + n6;
                    b = true;
                }
            } while (!b);
            if (Math.abs(nextInt - x2) < Math.abs(nextInt - x)) {
                System.out.println(x2);
            }
            else {
                System.out.println(x);
            }
        }
        else {
            System.out.println(nextInt);
        }
        scanner.close();
    }
}
