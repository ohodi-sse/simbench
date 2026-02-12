import java.util.HashSet;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int j = nextInt;
        int a = 0;
        while (j > 0) {
            if (!set.contains(j)) {
                a = j;
                break;
            }
            --j;
        }
        int k = nextInt;
        int a2 = 101;
        while (k <= 100) {
            if (!set.contains(k)) {
                a2 = k;
                break;
            }
            ++k;
        }
        int x;
        if (Math.abs(a) == Math.abs(a2)) {
            if (a > a2) {
                x = a2;
            }
            else {
                x = a;
            }
        }
        else if (Math.abs(nextInt - a) > Math.abs(nextInt - a2)) {
            x = a2;
        }
        else {
            x = a;
        }
        System.out.println(x);
    }
}
