import java.util.Iterator;
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
            final int abs = Math.abs((int)list3.get(k) - nextInt);
            if (abs < n) {
                n = abs;
                intValue2 = (int)list3.get(k);
            }
        }
        System.out.println(intValue2);
    }
}
