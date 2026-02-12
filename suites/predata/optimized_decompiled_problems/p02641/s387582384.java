import java.util.Iterator;
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
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        final ArrayList list2 = new ArrayList();
        for (int j = -50; j < 51; ++j) {
            list2.add(nextInt + j);
        }
        final ArrayList list3 = new ArrayList();
        for (final int intValue : list2) {
            if (!list.contains(intValue)) {
                list3.add(intValue);
            }
        }
        int n = 51;
        int intValue2 = 0;
        for (int k = 0; k < list3.size(); ++k) {
            final int abs;
            if ((abs = Math.abs((int)list3.get(k) - nextInt)) < n) {
                n = abs;
                intValue2 = (int)list3.get(k);
            }
        }
        System.out.println(intValue2);
    }
}
