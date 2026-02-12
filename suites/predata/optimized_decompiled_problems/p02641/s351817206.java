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
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
            set.add(array[i]);
        }
        int n = 0;
        while (true) {
            final int n2 = nextInt - n;
            if (!set.contains(n2)) {
                System.out.println(n2);
                return;
            }
            final int n3 = nextInt + n;
            if (!set.contains(n3)) {
                System.out.println(n3);
                return;
            }
            ++n;
        }
    }
}
