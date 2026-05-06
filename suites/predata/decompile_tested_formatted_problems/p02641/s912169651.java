import java.util.List;
import java.util.Collections;
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
        int n = 0;
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= list.size(); ++j) {
            if (n == 0) {
                if (!list.contains(nextInt + j)) {
                    list2.add(nextInt + j);
                    n = 1;
                }
                if (!list.contains(nextInt - j)) {
                    list2.add(nextInt - j);
                    n = 1;
                }
                if (n == 1) {
                    break;
                }
            }
        }
        Collections.sort((List<Comparable>)list2);
        if (nextInt2 > 0) {
            System.out.println(list2.get(0));
        }
        else {
            System.out.println(nextInt);
        }
    }
}
