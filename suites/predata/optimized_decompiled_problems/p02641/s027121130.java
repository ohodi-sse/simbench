import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = nextInt - 1;
        int k = nextInt + 1;
        Collections.sort((List<Comparable>)list);
        if (!list.contains(nextInt)) {
            System.out.print(nextInt);
            return;
        }
        int l = 0;
        while (l < nextInt2) {
            if (list.contains(j)) {
                --j;
            }
            if (list.contains(k)) {
                ++k;
            }
            if (!list.contains(j) && !list.contains(k)) {
                if (Math.abs(nextInt - j) > Math.abs(nextInt - k)) {
                    System.out.print(k);
                    return;
                }
                System.out.print(j);
            }
            else {
                ++l;
            }
        }
    }
}
