import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashMap hashMap = new HashMap();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            hashMap.put(array2[i], 1);
            min = Math.min(min, array2[i]);
            max = Math.max(max, array2[i]);
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            System.out.println(some(array2, nextInt, nextInt2, hashMap, min, max));
        }
    }
    
    public static int some(final int[] array, final int n, final int n2, final HashMap<Integer, Integer> hashMap, final int n3, final int n4) {
        if (n < n3) {
            if (n - 1 <= n3) {
                return n - 1;
            }
            return n + 1;
        }
        else if (n > n4) {
            if (n - 1 > n4) {
                return n - 1;
            }
            return n + 1;
        }
        else {
            final ArrayList list = new ArrayList();
            for (int i = n3; i <= n4; ++i) {
                if (!hashMap.containsKey(i)) {
                    list.add(i);
                }
            }
            if (list.size() != 0) {
                int n5 = Integer.MAX_VALUE;
                int n6 = 0;
                Collections.sort((List<Comparable>)list);
                while (list.size() != 0) {
                    final int intValue = list.get(0);
                    final int abs = Math.abs(n - intValue);
                    if (abs < n5) {
                        n5 = abs;
                        n6 = intValue;
                    }
                    list.remove(0);
                }
                return n6;
            }
            if (Math.abs(n3 - 1 - n) > Math.abs(n4 + 1 - n)) {
                return n4 + 1;
            }
            return n3 - 1;
        }
    }
}
