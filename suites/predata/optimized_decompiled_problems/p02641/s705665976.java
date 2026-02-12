import java.util.List;
import java.util.Collections;
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
        final int nextInt = scanner.nextInt();
        for (int nextInt2 = scanner.nextInt(), i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        while (true) {
            int n;
            for (n = 0; list.contains(nextInt - n); ++n) {
                if (!list.contains(nextInt + n)) {
                    final int x = nextInt + n;
                    System.out.println(x);
                    return;
                }
            }
            final int x = nextInt - n;
            continue;
        }
    }
}
