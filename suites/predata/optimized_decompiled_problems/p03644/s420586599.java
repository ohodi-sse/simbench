import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) == 1) {
            System.out.println(1);
            System.exit(0);
        }
        final HashMap hashMap = new HashMap();
        for (int i = 1; i <= nextInt; ++i) {
            int n = i;
            int j = 0;
            while (n % 2 == 0) {
                ++j;
                n /= 2;
            }
            hashMap.put(i, j);
        }
        int intValue = 0;
        int intValue2 = 0;
        final Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry entry;
            if ((int)(entry = (Map.Entry)iterator.next()).getValue() > intValue2) {
                intValue2 = (int)entry.getValue();
                intValue = (int)entry.getKey();
            }
        }
        System.out.println(intValue);
    }
}
