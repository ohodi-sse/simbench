import java.util.ArrayList;
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
            return;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int x = Integer.MAX_VALUE;
        for (int j = 1; j <= nextInt2; ++j) {
            final int k = nextInt + j;
            if (!list.contains(k)) {
                x = k;
                break;
            }
        }
        int x2 = Integer.MAX_VALUE;
        for (int l = 0; l <= nextInt2; ++l) {
            final int m = nextInt - l;
            if (!list.contains(m)) {
                x2 = m;
                break;
            }
        }
        if (Math.abs(nextInt - x2) <= Math.abs(nextInt - x)) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}
