import java.util.Collection;
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
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        final ArrayList coll;
        (coll = new ArrayList()).add(0);
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                coll.set(n, (int)coll.get(n) + 1);
            }
            if (next.charAt(i) == 'S') {
                ++n;
                coll.add(0);
            }
        }
        System.out.println(Collections.max((Collection<?>)coll));
    }
}
