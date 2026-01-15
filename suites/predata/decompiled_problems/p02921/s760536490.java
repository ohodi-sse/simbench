import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        int x = 0;
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < 3; ++i) {
            list.add(next.substring(i, i + 1));
            list2.add(next2.substring(i, i + 1));
        }
        for (int j = 0; j < list.size(); ++j) {
            if (((String)list.get(j)).equals(list2.get(j))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
