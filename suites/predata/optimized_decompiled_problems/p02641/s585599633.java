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
        int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        while (nextInt2-- != 0) {
            set.add(scanner.nextInt());
        }
        int n;
        for (n = 0; set.contains(nextInt - n) && set.contains(nextInt + n); ++n) {}
        if (!set.contains(nextInt - n)) {
            System.out.println(nextInt - n);
            return;
        }
        if (!set.contains(nextInt + n)) {
            System.out.println(nextInt + n);
        }
    }
}
