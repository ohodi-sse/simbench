import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static int indexOf(final int[] array, final int n) {
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
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            scanner.close();
            return;
        }
        final int[] a = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        final int index = indexOf(a, nextInt);
        if (index != -1) {
            int n = 0;
            boolean b;
            int x;
            int x2;
            do {
                ++n;
                b = false;
                x = Integer.MIN_VALUE;
                x2 = Integer.MAX_VALUE;
                if (index - n < 0) {
                    x = nextInt - n;
                    b = true;
                }
                else if (a[index - n] != nextInt - n) {
                    x = nextInt - n;
                    b = true;
                }
                if (index + n >= nextInt2) {
                    x2 = nextInt + n;
                    b = true;
                }
                else {
                    if (a[index + n] == nextInt + n) {
                        continue;
                    }
                    x2 = nextInt + n;
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
