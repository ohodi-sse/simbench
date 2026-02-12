import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
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
        if ((nextInt2 = scanner.nextInt()) != 0) {
            final int[] a = new int[nextInt2];
            for (int i = 0; i < nextInt2; ++i) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            final int[] array = new int[a[nextInt2 - 1] - a[0] + 3];
            int n = 0;
            for (int j = a[0] - 1; j <= a[nextInt2 - 1] + 1; ++j) {
                array[n] = j;
                ++n;
            }
            final ArrayList<Integer> list;
            (list = toList(array)).removeAll(toList(a));
            final ArrayList list2 = new ArrayList();
            final ArrayList list3 = new ArrayList();
            for (final Integer n2 : list) {
                list2.add(Math.abs(n2 - nextInt));
                list3.add(n2);
            }
            final Object[] array2 = list2.toArray();
            final Object[] array3 = list3.toArray();
            int n3 = (int)array2[0];
            int n4 = 0;
            for (int k = 1; k < array2.length; ++k) {
                if (n3 > (int)array2[k]) {
                    n3 = (int)array2[k];
                    n4 = k;
                }
            }
            System.out.println(array3[n4]);
            return;
        }
        System.out.println(nextInt);
    }
    
    private static ArrayList<Integer> toList(final int[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        return list;
    }
}
