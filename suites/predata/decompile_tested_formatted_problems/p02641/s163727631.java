import java.util.ArrayList;
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
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        final ArrayList list = new ArrayList();
        for (int j = 0; j <= 101; ++j) {
            boolean b = false;
            for (int k = 0; k < array2.length; ++k) {
                if (j == array2[k]) {
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
