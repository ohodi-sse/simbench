import java.util.HashMap;
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
        final HashMap hashMap = new HashMap();
        for (int i = 1; i <= nextInt2; ++i) {
            hashMap.put(scanner.nextInt(), 1);
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        int x;
        int n;
        for (x = nextInt, n = nextInt; hashMap.containsKey(x) && hashMap.containsKey(n); --x, ++n) {}
        if (!hashMap.containsKey(x)) {
            System.out.println(x);
            return;
        }
        System.out.println(n);
    }
}
