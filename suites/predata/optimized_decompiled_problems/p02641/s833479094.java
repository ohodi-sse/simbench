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
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
            hashMap.put(array[i], Boolean.TRUE);
        }
        int n;
        int n2;
        for (n = nextInt, n2 = 0; hashMap.containsKey(n - n2); ++n2) {
            if (!hashMap.containsKey(n + n2)) {
                System.out.println(n + n2);
                return;
            }
        }
        System.out.println(n - n2);
    }
}
