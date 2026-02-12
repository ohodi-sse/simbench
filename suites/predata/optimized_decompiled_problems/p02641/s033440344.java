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
        if (nextInt2 == 0 || !list.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        int n = 1;
        int n2;
        int n3;
        while (true) {
            n2 = nextInt - n;
            n3 = nextInt + n;
            if (!list.contains(n2) || !list.contains(n3)) {
                break;
            }
            ++n;
        }
        if (!list.contains(n2) && !list.contains(n2)) {
            System.out.println(n2);
            return;
        }
        if (!list.contains(n2)) {
            System.out.println(n2);
            return;
        }
        System.out.println(n3);
    }
}
