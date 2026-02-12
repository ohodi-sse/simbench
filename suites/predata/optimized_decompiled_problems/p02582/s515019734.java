import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list = new ArrayList();
        final String next = scanner.next();
        int n = 0;
        int x = 0;
        int x2 = 0;
        if (next.equals("RRR")) {
            x2 = 3;
        }
        else {
            for (int i = 0; i < 3; ++i) {
                final ArrayList list2 = list;
                final String s = next;
                final int beginIndex = i;
                list2.add(s.substring(beginIndex, beginIndex + 1));
            }
            for (int j = 0; j < 3; ++j) {
                if (!((String)list.get(j)).equals("R")) {
                    n = 0;
                    break;
                }
                n = 1;
            }
            for (int k = 0; k < 3; ++k) {
                if (((String)list.get(k)).equals("R")) {
                    ++x;
                }
                else if (((String)list.get(k)).equals("S") && x2 < x) {
                    x2 = x;
                    x = 0;
                }
            }
        }
        if (n == 1) {
            System.out.println("3");
            return;
        }
        if (x > x2) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}
