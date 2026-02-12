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
        for (int i = 1; i <= nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        for (int j = 0; j <= 100; ++j) {
            if (!set.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!set.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
        System.out.println(0);
    }
}
