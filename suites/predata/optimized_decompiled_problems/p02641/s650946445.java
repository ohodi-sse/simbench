import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        int min = 101;
        for (int j = 0; j < 102; ++j) {
            if (!list.contains(j)) {
                min = Math.min(min, Math.abs(nextInt - j));
            }
        }
        if (list.contains(nextInt - min)) {
            System.out.println(nextInt + min);
            return;
        }
        System.out.println(nextInt - min);
    }
}
