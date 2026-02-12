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
        int n = 200;
        int x = 0;
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (!set.contains(j) && (abs = Math.abs(j - nextInt)) < n) {
                n = abs;
                x = j;
            }
        }
        System.out.println(x);
    }
}
