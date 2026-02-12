import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        final Vector coll = new Vector();
        int i = 0;
        while (i < next.length()) {
            if (next.charAt(i) == 'R') {
                int j;
                for (j = 0; i < next.length() && next.charAt(i) == 'R'; ++i, ++j) {}
                coll.add(j);
            }
            else {
                while (i < next.length() && next.charAt(i) == 'S') {
                    ++i;
                }
            }
        }
        if (coll.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(Collections.max((Collection<?>)coll));
    }
}
