import java.util.HashMap;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            hashMap.put(array2[i], true);
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
