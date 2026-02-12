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
        int n = 0;
        int x;
        while (true) {
            x = nextInt - n;
            if (!set.contains(x)) {
                break;
            }
            x = nextInt + n;
            if (!set.contains(x)) {
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}
