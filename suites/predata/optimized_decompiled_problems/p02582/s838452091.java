import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                int j;
                for (j = 0; i <= next.length() - 1 && next.charAt(i) != 'S'; ++i, ++j) {}
                list.add(j);
                --i;
            }
        }
        int max = Integer.MIN_VALUE;
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, (int)iterator.next());
        }
        if (max < 0) {
            System.out.println("0");
            return;
        }
        System.out.println(max);
    }
}
