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
        int x = -1;
        if (set.isEmpty()) {
            x = nextInt;
        }
        else {
            for (int j = 0; j <= 105; ++j) {
                if (!set.contains(j) && Math.abs(x - nextInt) > Math.abs(j - nextInt)) {
                    x = j;
                }
            }
        }
        System.out.println(x);
        System.out.flush();
        scanner.close();
    }
}
