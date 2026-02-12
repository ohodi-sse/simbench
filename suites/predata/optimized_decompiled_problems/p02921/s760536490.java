import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int x = 0;
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < 3; ++i) {
            final ArrayList list3 = list;
            final String s = next;
            final int beginIndex = i;
            list3.add(s.substring(beginIndex, beginIndex + 1));
            final ArrayList list4 = list2;
            final String s2 = next2;
            final int beginIndex2 = i;
            list4.add(s2.substring(beginIndex2, beginIndex2 + 1));
        }
        for (int j = 0; j < list.size(); ++j) {
            if (((String)list.get(j)).equals(list2.get(j))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
