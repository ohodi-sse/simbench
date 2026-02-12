import java.util.List;
import java.util.Collections;
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
            return;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        int n = Integer.MAX_VALUE;
        int x = -1;
        final int n2 = (int)list.get(0) - 1;
        int j = (nextInt < n2) ? nextInt : n2;
        final ArrayList list2 = list;
        int n3;
        while (j <= (((n3 = (int)list2.get(list2.size() - 1) + 1) < nextInt) ? nextInt : n3)) {
            final int abs;
            if (!list.contains(j) && (abs = Math.abs(nextInt - j)) < n) {
                n = abs;
                x = j;
            }
            ++j;
        }
        System.out.println(x);
    }
}
