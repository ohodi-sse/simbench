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
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final ArrayList list = new ArrayList();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
            list.add(array[i]);
        }
        if (!list.contains(nextInt)) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int j = 0; j <= nextInt2; ++j) {
            if (!list.contains(nextInt + j) || !list.contains(nextInt - j)) {
                if (!list.contains(nextInt - j)) {
                    System.out.println(nextInt - j);
                    return;
                }
                if (!list.contains(nextInt + j)) {
                    System.out.println(nextInt + j);
                    return;
                }
            }
        }
    }
}
