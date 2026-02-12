import java.util.HashSet;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int nextInt2;
        final int n = nextInt2 = scanner.nextInt();
        int x = 999;
        final int[] array = new int[n];
        int n2 = 100;
        final HashSet set = new HashSet();
        for (int i = 0; i < n; ++i) {
            set.add(scanner.nextInt());
        }
        set.add(nextInt);
        if (set.size() != n) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int j = -100; j <= 200; ++j) {
            set.add(j);
            if (set.size() != nextInt2) {
                if (Math.abs(nextInt - j) < n2) {
                    n2 = nextInt - j;
                    x = j;
                }
                ++nextInt2;
            }
        }
        System.out.println(x);
    }
}
