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
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int x = 0;
        int abs = 1073741823;
        for (int j = -100; j <= 200; ++j) {
            if (!set.contains(j) && Math.abs(j - nextInt) < abs) {
                x = j;
                abs = Math.abs(j - nextInt);
            }
        }
        System.out.println(x);
    }
}
