import java.util.List;
import java.util.Arrays;
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
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            scanner.close();
            System.exit(0);
        }
        final Integer[] a = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        final List<Integer> list = Arrays.asList(a);
        scanner.close();
        int x = 0;
        int j = 1;
        if (!list.contains(nextInt)) {
            x = nextInt;
            j = 0;
        }
        int n = 0;
        while (j != 0) {
            ++n;
            final int k = nextInt - n;
            final int l = nextInt + n;
            if (!list.contains(k)) {
                x = k;
                j = 0;
            }
            else {
                if (list.contains(l)) {
                    continue;
                }
                x = l;
                j = 0;
            }
        }
        System.out.println(x);
    }
}
