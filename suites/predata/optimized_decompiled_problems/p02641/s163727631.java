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
            System.exit(0);
        }
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        final ArrayList list = new ArrayList();
        for (int j = 0; j <= 101; ++j) {
            boolean b = false;
            for (int k = 0; k < array.length; ++k) {
                if (j == array[k]) {
                    b = true;
                }
            }
            if (!b) {
                list.add(j);
            }
        }
        int n = 0;
        int intValue = 0;
        for (int l = 0; l < list.size(); ++l) {
            final int abs = Math.abs(nextInt - list.get(l));
            if (l == 0) {
                n = abs;
            }
            if (n > abs) {
                n = abs;
                intValue = (int)list.get(l);
            }
        }
        System.out.println(intValue);
    }
}
