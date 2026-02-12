import java.util.HashSet;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        if (!scanner.hasNext()) {
            System.out.println(0);
            return;
        }
        if (scanner.nextInt() == 0) {
            System.out.println(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        while (scanner.hasNext()) {
            set.add(scanner.nextInt());
        }
        while (true) {
            int n;
            for (n = 0; set.contains(nextInt - n); ++n) {
                if (!set.contains(nextInt + n)) {
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
