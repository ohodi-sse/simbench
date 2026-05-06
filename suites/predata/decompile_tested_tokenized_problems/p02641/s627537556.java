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
        final ArrayList list2 = new ArrayList();
        boolean b = true;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
            if ((int)list.get(i) == nextInt) {
                b = false;
            }
        }
        if (b) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int j = 0; j <= 101; ++j) {
            list2.add(j);
        }
        for (int k = 0; k < list.size(); ++k) {
            for (int l = 0; l < list2.size(); ++l) {
                if ((int)list2.get(l) != nextInt && list.get(k) == list2.get(l)) {
                    list2.remove(l);
                }
            }
        }
        final int index = list2.indexOf(nextInt);
        if (nextInt - (int)list2.get(index - 1) <= (int)list2.get(index + 1) - nextInt) {
            System.out.println(list2.get(index - 1));
        }
        else {
            System.out.println(list2.get(index + 1));
        }
        scanner.close();
    }
}
