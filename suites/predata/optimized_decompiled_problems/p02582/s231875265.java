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
        final String next;
        final int[] array = new int[(next = new Scanner(System.in).next()).length()];
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                final int[] array2 = array;
                final int n2 = n;
                ++array2[n2];
            }
            else {
                ++n;
            }
        }
        final Vector coll = new Vector();
        for (int j = 0; j < array.length; ++j) {
            coll.add(array[j]);
        }
        System.out.println(Collections.max((Collection<?>)coll));
    }
}
