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
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            scanner.close();
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        for (int j = 0; j <= 100; ++j) {
            if (!set.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                break;
            }
            if (!set.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                break;
            }
        }
        scanner.close();
    }
}
